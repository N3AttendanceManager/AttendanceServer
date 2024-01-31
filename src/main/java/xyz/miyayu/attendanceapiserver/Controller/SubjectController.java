package xyz.miyayu.attendanceapiserver.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import xyz.miyayu.attendanceapiserver.Controller.Response.SubjectResponse;
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
    public SubjectResponse getAllSubjects() {
        final var subjects = subjectRepository.findAll();
        final var response = new SubjectResponse();
        response.setSubjects(subjects);
        return response;
    }

    @PostMapping("")
    public @ResponseBody
    String addNewSubject(@RequestParam String name, int departmentId) {
        try {
            SubjectEntity n = new SubjectEntity();
            n.setName(name);
            n.setDepartmentId(departmentId);
            subjectRepository.save(n);
            return "DataSaved";
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid request data");
        }
    }
}
