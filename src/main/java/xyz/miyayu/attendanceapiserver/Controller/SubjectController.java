package xyz.miyayu.attendanceapiserver.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.miyayu.attendanceapiserver.Entity.SubjectEntity;
import xyz.miyayu.attendanceapiserver.Repository.SubjectRepository;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectController(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @GetMapping("")
    public Iterable<SubjectEntity> getAllSubjects() {
        return subjectRepository.findAll();
    }

    @PostMapping("")
    public @ResponseBody
    String addNewSubject(@RequestParam String name, int department_id) {
        SubjectEntity n = new SubjectEntity();
        n.setName(name);
        n.setDepartmentId(department_id);
        subjectRepository.save(n);
        return "DataSaved";
    }
}
