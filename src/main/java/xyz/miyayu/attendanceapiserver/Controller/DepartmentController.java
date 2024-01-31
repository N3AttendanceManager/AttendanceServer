package xyz.miyayu.attendanceapiserver.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.miyayu.attendanceapiserver.Entity.DepartmentEntity;
import xyz.miyayu.attendanceapiserver.Repository.DepartmentRepository;

import java.util.List;

@RestController
@RequestMapping("department")
public class DepartmentController {
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentController(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }

    @GetMapping("")
    public Iterable<DepartmentEntity> getAllDepartments(){
        return departmentRepository.findAll();
    }

}
