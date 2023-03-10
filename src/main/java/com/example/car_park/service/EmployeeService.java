package com.example.car_park.service;

import com.example.car_park.entities.Car;
import com.example.car_park.entities.Employee;
import com.example.car_park.entities.dto.CarDTO;
import com.example.car_park.entities.dto.EmployeeDTO;
import com.example.car_park.exception.DuplicatedAccountException;
import com.example.car_park.exception.DuplicatedEmailException;
import com.example.car_park.exception.DuplicatedPhoneException;
import com.example.car_park.exception.NotFoundException;
import com.example.car_park.repository.EmployeeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EntityManager em;

    // Add Employee mới
    public EmployeeDTO addEmployee(Employee employee){
        List<Employee> employees = employeeRepository.getEmployeeToCheckByAccount(employee.getAccount());
        if(employees.size() == 0){
            employees = employeeRepository.getEmployeeToCheckByPhone(employee.getEmployeePhone());
            if(employees.size() == 0) {
                employees = employeeRepository.getEmployeeToCheckByEmail(employee.getEmployeeEmail());
                if(employees.size() == 0){
                    employeeRepository.save(employee);
                    return new EmployeeDTO(employee);
                } else {
                    throw new DuplicatedEmailException("Duplicate Employee By Email");
                }
            } else {
                throw new DuplicatedPhoneException("Duplicate Employee By Phone");
            }
        } else {
            throw new DuplicatedAccountException("Duplicate Employee By Account");
        }
    }

    // Select danh sách Employee
    public List<EmployeeDTO> selectAllEmployee(){
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        for(Employee e : employees){
            employeeDTOS.add(new EmployeeDTO(e));
        }
        return employeeDTOS;
    }

    // Select Employee theo account
    public List<EmployeeDTO> selectEmployeeByAccount(String account){
        List<Employee> employees = employeeRepository.searchEmployeeByAccount(account);
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        for(Employee e : employees){
            employeeDTOS.add(new EmployeeDTO(e));
        }
        return employeeDTOS;
    }

    // Select Employee theo giới tính
    public List<EmployeeDTO> selectEmployeeBySex(String sex){
        List<Employee> employees = employeeRepository.searchEmployeeBySex(sex);
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        for(Employee e : employees){
            employeeDTOS.add(new EmployeeDTO(e));
        }
        return employeeDTOS;
    }

    // Select Employee theo id
    public EmployeeDTO selectEmployeeById(long id){
        Optional<Employee> employeeData = employeeRepository.findById(id);
        if(employeeData.isPresent()){
            return new EmployeeDTO(employeeData.get());
        }else{
            throw new NotFoundException("Employee id = "+ id + " not found");
        }
    }

    // Update Employee theo id
    public String updateEmployee(long id, Employee updatedEmployee){
        Optional<Employee> employeeData = employeeRepository.findById(id);
        if(employeeData.isPresent()){
            employeeRepository.myUpdateFunction(updatedEmployee.getEmployeeAddress(),
                    updatedEmployee.getEmployeeBirthdate(),
                    updatedEmployee.getEmployeeEmail(),
                    updatedEmployee.getEmployeeName(),
                    updatedEmployee.getEmployeePhone(),
                    updatedEmployee.getAccount(),
                    updatedEmployee.getDepartment(),
                    updatedEmployee.getPassword(),
                    updatedEmployee.getSex(),
                    id);
            return "Updated";
        } else {
            throw new NotFoundException("Employee id = " + id + " not found");
        }
    }

    // Xóa Employee theo Id
    public String deleteById(long id){
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if(employeeOptional.isPresent()){
            employeeRepository.deleteById(id);
            return "Deleted successfully";
        }else{
            throw new NotFoundException("Employee id = "+ id + " not found");
        }
    }

    public List<EmployeeDTO> getAllEmployees(String searchName, String field, int offset, int limit) {
        String sql = "select e from Employee e where " + field + " like :search";
        StringBuilder query = new StringBuilder(sql);

        TypedQuery<Employee> employees = em.createQuery(query.toString(), Employee.class);
        employees.setParameter("search", searchName);
        employees.setFirstResult(offset);
        employees.setMaxResults(limit);
        List<Employee> emList = employees.getResultList();
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        for (Employee e : emList) {
            employeeDTOS.add(new EmployeeDTO(e));
        }
        return employeeDTOS;
    }
}
