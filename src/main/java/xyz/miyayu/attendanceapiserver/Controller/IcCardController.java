package xyz.miyayu.attendanceapiserver.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.miyayu.attendanceapiserver.Controller.Request.StudentRequest;
import xyz.miyayu.attendanceapiserver.Entity.StudentEntity;
import xyz.miyayu.attendanceapiserver.Repository.StudentRepository;
import xyz.miyayu.attendanceapiserver.Service.StudentService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ic")
public class IcCardController {
    private  final StudentService studentService;
    @PostMapping("")
    public void update(@RequestBody StudentRequest request,@RequestParam("studentId") Integer studentId,@RequestParam("icId") String icId) {
        studentService.updateStudent(studentId, request);
    }
}
