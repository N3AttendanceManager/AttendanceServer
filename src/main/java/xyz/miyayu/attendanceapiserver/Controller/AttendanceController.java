package xyz.miyayu.attendanceapiserver.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.miyayu.attendanceapiserver.Controller.Request.AttendanceRequest;
import xyz.miyayu.attendanceapiserver.Entity.AttendanceEntity;
import xyz.miyayu.attendanceapiserver.Repository.AttendanceRepository;
import xyz.miyayu.attendanceapiserver.Service.AttendanceService;

@RestController
@RequestMapping("attendance")
public class AttendanceController {

    private final AttendanceRepository attendanceRepository;
    private final AttendanceService attendanceService;
    @Autowired
    public AttendanceController(AttendanceRepository attendanceRepository, AttendanceService attendanceService) {
        this.attendanceRepository = attendanceRepository;
        this.attendanceService = attendanceService;
    }

    @GetMapping("")
    public Iterable<AttendanceEntity> getAllAttendances() {
        return  attendanceRepository.findAll();
    }

    @PostMapping("/manual")
    public void update(@RequestBody AttendanceRequest request,@RequestParam("studentId") Integer studentId,@RequestParam("classId") Integer classId,@RequestParam("atClassificationId") Integer atClassificationId) {
        attendanceService.updateAttendanceByStudentId(studentId, request);
    }

    @PostMapping("/ic")
    public void updateByIc(@RequestBody AttendanceRequest request,@RequestParam("icId") String icId,@RequestParam("classId")Integer classId,@RequestParam("atClassificationId") Integer atClassificationId) {
        attendanceService.updateAttendanceByIcId(icId, request);
    }

}
