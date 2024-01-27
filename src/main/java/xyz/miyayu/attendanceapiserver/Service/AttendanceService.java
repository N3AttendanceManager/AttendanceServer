package xyz.miyayu.attendanceapiserver.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
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
    public void updateAttendanceByStudentId(int studentId, AttendanceRequest request) {
        AttendanceEntity attendanceEntity = attendanceRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("NOT FOUND STUDENT"));
        attendanceEntity.setAtClassificationId((request.getAtClassificationId()));
        modelMapper.map(request, attendanceEntity);
    }

    @Transactional
    public  void updateAttendanceByIcId(String icId, AttendanceRequest request) {
        List<StudentEntity> studentEntities = studentRepository.findAllByIcId(icId);
        studentEntities.forEach((studentEntity -> {
            AttendanceEntity attendanceEntity = attendanceRepository.findById(studentEntity.getAutoId())
                    .orElseThrow(() -> new RuntimeException("NOT FOUND STUDENT"));
            attendanceEntity.setAtClassificationId((request.getAtClassificationId()));
            modelMapper.map(request, attendanceEntity);
        }));
    }
}
