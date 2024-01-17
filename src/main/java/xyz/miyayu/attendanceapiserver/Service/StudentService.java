package xyz.miyayu.attendanceapiserver.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import xyz.miyayu.attendanceapiserver.Controller.Request.StudentRequest;
import xyz.miyayu.attendanceapiserver.Entity.StudentEntity;
import xyz.miyayu.attendanceapiserver.Repository.StudentRepository;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public void updateStudent(int autoId, StudentRequest request) {
        StudentEntity studentEntity = studentRepository.findById(autoId)
                .orElseThrow(() -> new RuntimeException("NOT FOUND STUDENT"));
        studentEntity.setIcId((request.getIcId()));
        modelMapper.map(request, studentEntity);
    }
}
