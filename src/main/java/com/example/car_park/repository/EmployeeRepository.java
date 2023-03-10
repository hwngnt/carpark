package com.example.car_park.repository;

import com.example.car_park.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.domain.Pageable;
import java.util.Date;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Tìm kiếm Employee theo account
    @Query(value = "SELECT * FROM Employee e WHERE e.account LIKE %?1%", nativeQuery = true)
    List<Employee> searchEmployeeByAccount(String account);

    // Tìm kiếm Employee theo giới tính
    @Query(value = "SELECT * FROM Employee e WHERE e.sex = ?1", nativeQuery = true)
    List<Employee> searchEmployeeBySex(String sex);

    @Query(value="SELECT * FROM Employee e WHERE e.account=?1", nativeQuery = true)
    List<Employee> getEmployeeToCheckByAccount(String account);

    @Query(value="SELECT * FROM Employee e WHERE e.employee_phone=?1", nativeQuery = true)
    List<Employee> getEmployeeToCheckByPhone(String employeePhone);

    @Query(value="SELECT * FROM Employee e WHERE e.employee_email=?1", nativeQuery = true)
    List<Employee> getEmployeeToCheckByEmail(String employeeEmail);

    @Modifying
    @Transactional
    @Query(value = "UPDATE employee e SET e.employee_address = ?1, e.employee_birthdate=?2, " +
            "e.employee_email = ?3, e.employee_name = ?4, e.employee_phone = ?5, " +
            "e.account = ?6, e.department=?7, e.password = ?8, e.sex = ?9 " +
            "WHERE e.employee_id = ?10", nativeQuery = true)
    int myUpdateFunction(String address, Date birthDate, String email,
                              String name, String phone, String account, String department,
                              String password, String sex, long id);
}
