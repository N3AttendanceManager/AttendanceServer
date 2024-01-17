package xyz.miyayu.attendanceapiserver.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.miyayu.attendanceapiserver.Entity.StudentEntity;
import xyz.miyayu.attendanceapiserver.Entity.TeacherEntity;
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
    public Iterable<TeacherEntity> getAllTeacher() {
        return teacherRepository.findAll();
    }
}
