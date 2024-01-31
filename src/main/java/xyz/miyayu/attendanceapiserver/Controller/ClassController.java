package xyz.miyayu.attendanceapiserver.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import xyz.miyayu.attendanceapiserver.Controller.Response.ClassResponse;
import xyz.miyayu.attendanceapiserver.Entity.ClassEntity;
import xyz.miyayu.attendanceapiserver.Repository.ClassRepository;

import java.sql.Date;
import java.time.LocalDateTime;

@RestController
@RequestMapping("class")
public class ClassController {
    private final ClassRepository classRepository;
    @Autowired
    public ClassController(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }
    @GetMapping("")
    public ClassResponse getAllClass() {
        final var classes = classRepository.findAll();
        final var response = new ClassResponse();
        response.setClasses(classes);
        return response;
    }
    @PostMapping("")
    public @ResponseBody
    String addNewClass(@RequestParam int subjectId, LocalDateTime startOn, LocalDateTime endOn) {
        try {
            ClassEntity n = new ClassEntity();
            n.setSubjectId(subjectId);
            n.setStartOn(startOn);
            n.setEndOn(endOn);
            classRepository.save(n);
            return "DataSaved";
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid request data");
        }
    }
}
