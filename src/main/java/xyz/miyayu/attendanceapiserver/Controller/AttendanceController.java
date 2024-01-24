package xyz.miyayu.attendanceapiserver.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.miyayu.attendanceapiserver.Entity.AttendanceEntity;
import xyz.miyayu.attendanceapiserver.Repository.AttendanceRepository;

@RestController
@RequestMapping("attendance")
public class AttendanceController {

    private final AttendanceRepository attendanceRepository;
    @Autowired
    public AttendanceController(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    @GetMapping("")
    public Iterable<AttendanceEntity> getAllAttendances() {
        return  attendanceRepository.findAll();
    }



}
