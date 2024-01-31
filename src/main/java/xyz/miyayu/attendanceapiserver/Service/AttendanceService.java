package xyz.miyayu.attendanceapiserver.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import xyz.miyayu.attendanceapiserver.Controller.Request.AttendanceRequest;
import xyz.miyayu.attendanceapiserver.Entity.AttendanceEntity;
import xyz.miyayu.attendanceapiserver.Entity.StudentEntity;
import xyz.miyayu.attendanceapiserver.Repository.AttendanceRepository;
import xyz.miyayu.attendanceapiserver.Repository.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceService {
    private final AttendanceRepository attendanceRepository;
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public void updateAttendanceByStudentId(AttendanceRequest request) {
        try {
            AttendanceEntity attendanceEntity = attendanceRepository.findById(request.getStudentAutoId())
                    .orElseThrow(() -> new RuntimeException("NOT FOUND STUDENT"));
            attendanceEntity.setAtClassificationId((request.getAtClassificationId()));
            modelMapper.map(request, attendanceEntity);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid request data");
        }

    }

    @Transactional
    public void updateAttendanceByIcId(String icId, AttendanceRequest request) {
        try {
            List<StudentEntity> studentEntities = studentRepository.findAllByIcId(icId);
            studentEntities.forEach((studentEntity -> {
                List<AttendanceEntity> attendanceEntities = attendanceRepository.findByStudentIdAndClassId(studentEntity.getAutoId(), request.getClassId());
                AttendanceEntity attendanceEntity;
                if (attendanceEntities.isEmpty()) {
                    attendanceEntity = new AttendanceEntity();
                    attendanceEntity.setStudentId(studentEntity.getAutoId());
                    attendanceEntity.setClassId(request.getClassId());
                    System.out.print("Not Found");

                } else {
                    attendanceEntity = attendanceEntities.get(0);
                    System.out.print("Found");
                }
                System.out.println(attendanceEntity.getStudentId() + ":" + attendanceEntity.getClassId());

                attendanceEntity.setAtClassificationId((request.getAtClassificationId()));
                attendanceEntity.setTeacherId(1);
                attendanceRepository.save(attendanceEntity);
            }));
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid request data");
        }
    }
}
