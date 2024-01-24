package xyz.miyayu.attendanceapiserver.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.miyayu.attendanceapiserver.Entity.StudentEntity;
import xyz.miyayu.attendanceapiserver.Entity.response.StudentResponse;
import xyz.miyayu.attendanceapiserver.Repository.StudentRepository;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("")
    public StudentResponse getAllStudents() {
        final var students = studentRepository.findAll();
        final var response = new StudentResponse();
        response.setStudents(students);
        return response;
    }

    @GetMapping("/[selectId]")
    public StudentEntity getStudentById(@RequestParam int autoId) {
        return studentRepository.findById(autoId).orElse(null);
    }

    @PostMapping("")
    public @ResponseBody
    String addNewStudent(@RequestParam String studentId, String name, int departmentId, String icId) {
        StudentEntity n = new StudentEntity();
        n.setStudentId(studentId);
        n.setName(name);
        n.setDepartmentId(departmentId);
        //n.setIcId(icId);
        studentRepository.save(n);
        return "DataSaved";
    }
}
