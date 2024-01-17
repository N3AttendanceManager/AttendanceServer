package xyz.miyayu.attendanceapiserver.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.miyayu.attendanceapiserver.Entity.ClassEntity;
import xyz.miyayu.attendanceapiserver.Repository.ClassRepository;

import java.sql.Date;

@RestController
@RequestMapping("class")
public class ClassController {
    private final ClassRepository classRepository;
    @Autowired
    public ClassController(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }
    @GetMapping("")
    public Iterable<ClassEntity> getAllClass() {
        return classRepository.findAll();
    }
    @PostMapping("")
    public @ResponseBody
    String addNewClass(@RequestParam int subjectId, Date startOn, Date endOn) {
        ClassEntity n = new ClassEntity();
        n.setSubjectId(subjectId);
        n.setStartOn(startOn);
        n.setEndOn(endOn);
        classRepository.save(n);
        return "DataSaved";
    }
}
