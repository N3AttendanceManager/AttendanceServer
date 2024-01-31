package xyz.miyayu.attendanceapiserver.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
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
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AttendanceService {
    private final AttendanceRepository attendanceRepository;
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public void updateAttendanceByStudentId(AttendanceRequest request) {
        try {
            Optional<AttendanceEntity> optionalAttendanceEntity = attendanceRepository.findByStudentIdAndClassId(request.getStudentId(),request.getClassId());
            AttendanceEntity attendanceEntity;
            if(optionalAttendanceEntity.isPresent()){
                attendanceEntity = optionalAttendanceEntity.get();
            }else{
                attendanceEntity = new AttendanceEntity();
                attendanceEntity.setStudentId(request.getStudentId());
                attendanceEntity.setClassId(request.getClassId());
            }
            attendanceEntity.setAtClassificationId((request.getAtClassificationId()));
            attendanceEntity.setTeacherId(1);
            attendanceRepository.save(attendanceEntity);
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid request data");
        }

    }

    @Transactional
    public StudentEntity updateAttendanceByIcId(String icId, AttendanceRequest request) {
        try {
            List<StudentEntity> studentEntities = studentRepository.findAllByIcId(icId);
            if (studentEntities.isEmpty()) {
                return null;
            }
            var studentEntity = studentEntities.get(0);
            Optional<AttendanceEntity> attendanceEntities = attendanceRepository.findByStudentIdAndClassId(studentEntity.getAutoId(), request.getClassId());
            AttendanceEntity attendanceEntity;
            if (attendanceEntities.isEmpty()) {
                attendanceEntity = new AttendanceEntity();
                attendanceEntity.setStudentId(studentEntity.getAutoId());
                attendanceEntity.setClassId(request.getClassId());
                System.out.print("Not Found");

            } else {
                attendanceEntity = attendanceEntities.get();
                System.out.print("Found");
            }
            System.out.println(attendanceEntity.getStudentId() + ":" + attendanceEntity.getClassId());

            attendanceEntity.setAtClassificationId((request.getAtClassificationId()));
            attendanceEntity.setTeacherId(1);
            attendanceRepository.save(attendanceEntity);

            return studentEntity;
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid request data");
        }
    }
}
