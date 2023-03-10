package com.example.car_park.controller;

import com.example.car_park.entities.Employee;
import com.example.car_park.entities.dto.CarDTO;
import com.example.car_park.entities.dto.EmployeeDTO;
import com.example.car_park.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    // done
    // Thêm 1 user
    @PostMapping
    public EmployeeDTO addEmployee(@RequestBody @Valid Employee employee){
        return employeeService.addEmployee(employee);
    }

    // done
    //Lấy ra danh sách employee
    @GetMapping
    public List<EmployeeDTO> selectAllEmployee(){
        return employeeService.selectAllEmployee();
    }

    // done
    @GetMapping("/account/name/{account}")
    public List<EmployeeDTO> selectAllEmployeeByAccount(@PathVariable String account){
        return employeeService.selectEmployeeByAccount(account);
    }

    @GetMapping("/sex/{sex}")
    public List<EmployeeDTO> selectAllEmployeeBySex(@PathVariable String sex){
        return employeeService.selectEmployeeBySex(sex);
    }

    // done
    @GetMapping("/account")
    public EmployeeDTO selectAllEmployeeById(@RequestParam long id){
        return employeeService.selectEmployeeById(id);
    }

    // done
    @PutMapping
    public String updateEmployeeById(@RequestParam long id, @RequestBody Employee employee){
        return employeeService.updateEmployee(id, employee);
    }

    // done
    @DeleteMapping
    public String deleteEmployeeById(@RequestParam long id){
        return employeeService.deleteById(id);
    }

    @GetMapping("/filter")
    public List<EmployeeDTO> filter(@RequestParam(name = "offset", defaultValue = "0", required = true) int offset,
                               @RequestParam(name = "limit", defaultValue = "2", required = true) int limit,
                               @RequestParam(name = "searchField", defaultValue = "account", required = true) String field,
                               @RequestParam(name = "searchValue", defaultValue = "%%", required = false) String searchName){
        return employeeService.getAllEmployees("%"+searchName+"%", field, offset, limit);
    }
}
