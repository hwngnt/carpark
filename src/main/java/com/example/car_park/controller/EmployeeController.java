package com.example.car_park.controller;

import com.example.car_park.entities.Employee;
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

    @GetMapping("/page")
    public List<EmployeeDTO> selectEmployeeWithOffsetAndLimit(@RequestParam int page, @RequestParam int limit){
        return employeeService.getPage(page, limit);
    }

    @GetMapping("/selectByParam")
    public List<EmployeeDTO> selectEmployeByParam(@RequestParam String param, @RequestParam String order){
        return employeeService.sortPage(param, order);
    }

    @GetMapping("/filter")
    public List<EmployeeDTO> filter(@RequestParam String column, @RequestParam String param){
        return employeeService.filter(column, param);
    }
}
