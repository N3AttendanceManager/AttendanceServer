package xyz.miyayu.attendanceapiserver.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.miyayu.attendanceapiserver.Controller.Response.AtClassificationResponse;
import xyz.miyayu.attendanceapiserver.Entity.AtClassificationEntity;
import xyz.miyayu.attendanceapiserver.Entity.AttendanceEntity;
import xyz.miyayu.attendanceapiserver.Repository.AtClassificationRepository;

@RestController
@RequestMapping("AttendanceClass")
public class AtClassificationController {

    private final AtClassificationRepository atClassificationRepository;

    @Autowired
    public AtClassificationController(AtClassificationRepository atClassificationRepository) {
        this.atClassificationRepository = atClassificationRepository;
    }

    @GetMapping("")
    public AtClassificationResponse getAllAttendances() {
        final var atClassifications = atClassificationRepository.findAll();
        final var response = new AtClassificationResponse();
        response.setAtClassifications(atClassifications);
        return response;
    }
}
