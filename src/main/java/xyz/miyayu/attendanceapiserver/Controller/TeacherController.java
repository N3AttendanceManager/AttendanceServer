package xyz.miyayu.attendanceapiserver.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.miyayu.attendanceapiserver.Controller.Response.TeacherResponse;
import xyz.miyayu.attendanceapiserver.Repository.TeacherRepository;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    private final TeacherRepository teacherRepository;
    @Autowired
    public TeacherController(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }
    @GetMapping("")
    public TeacherResponse getAllTeacher() {
        final  var teachers = teacherRepository.findAll();
        final  var response = new TeacherResponse();
        response.setTeachers(teachers);
        return response;
    }
}
