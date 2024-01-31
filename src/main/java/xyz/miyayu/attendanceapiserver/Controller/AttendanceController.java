package xyz.miyayu.attendanceapiserver.Controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.miyayu.attendanceapiserver.Controller.Request.AttendanceRequest;
import xyz.miyayu.attendanceapiserver.Controller.Response.AttendanceResponse;
import xyz.miyayu.attendanceapiserver.Controller.Response.SingleStudentResponse;
import xyz.miyayu.attendanceapiserver.Entity.AttendanceEntity;
import xyz.miyayu.attendanceapiserver.Entity.StudentEntity;
import xyz.miyayu.attendanceapiserver.Repository.AttendanceRepository;
import xyz.miyayu.attendanceapiserver.Service.AttendanceService;

@RestController
@RequestMapping(value = "attendance")
public class AttendanceController {

    private final AttendanceRepository attendanceRepository;
    private final AttendanceService attendanceService;
    @Autowired
    public AttendanceController(AttendanceRepository attendanceRepository, AttendanceService attendanceService) {
        this.attendanceRepository = attendanceRepository;
        this.attendanceService = attendanceService;
    }

    @GetMapping("")
    public AttendanceResponse getAllAttendances() {
        final var attendances = attendanceRepository.findAll();
        final var response = new AttendanceResponse();
        response.setAttendances(attendances);
        return  response;
    }

    @PostMapping("/manual")
    public void update(@RequestBody AttendanceRequest request) {
        attendanceService.updateAttendanceByStudentId(request);
    }

    @PostMapping("/ic")
    public SingleStudentResponse updateByIc(@RequestBody AttendanceRequest request) {
        var student = attendanceService.updateAttendanceByIcId(request.getIcId(), request);
        var response = new SingleStudentResponse();
        response.setStudent(student);
        return response;
    }


}
