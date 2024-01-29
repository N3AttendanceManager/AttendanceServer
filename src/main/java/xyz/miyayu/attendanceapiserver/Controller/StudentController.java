package xyz.miyayu.attendanceapiserver.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import xyz.miyayu.attendanceapiserver.Entity.StudentEntity;
import xyz.miyayu.attendanceapiserver.Controller.Response.StudentResponse;
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

    @GetMapping("/{studentAutoId}")
    public ResponseEntity<StudentEntity> getStudentById(@PathVariable int studentAutoId) {
        return studentRepository.findById(studentAutoId)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Student not found"));
    }

    @PostMapping("")
    public @ResponseBody
    String addNewStudent(@RequestParam String studentId, String name, int departmentId, String icId) {
        try {
            StudentEntity n = new StudentEntity();
            n.setStudentId(studentId);
            n.setName(name);
            n.setDepartmentId(departmentId);
            //n.setIcId(icId);
            studentRepository.save(n);
            return "DataSaved";
        } catch (RuntimeException e) {
            //400エラーのスロー
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid request data");
        }
    }
}
