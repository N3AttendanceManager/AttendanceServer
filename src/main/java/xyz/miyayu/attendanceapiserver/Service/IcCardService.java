package xyz.miyayu.attendanceapiserver.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import xyz.miyayu.attendanceapiserver.Controller.Request.StudentRequest;
import xyz.miyayu.attendanceapiserver.Entity.StudentEntity;
import xyz.miyayu.attendanceapiserver.Repository.StudentRepository;

@Service
@RequiredArgsConstructor
public class IcCardService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public void updateStudent(StudentRequest request) {
        try {
            //findByIdで自動生成のIdの検索はできている
            StudentEntity studentEntity = studentRepository.findById(request.getStudentAutoId())
                    .orElseThrow(() -> new RuntimeException("NOT FOUND STUDENT"));
            studentEntity.setIcId((request.getIcId()));
            modelMapper.map(request, studentEntity);
        } catch (RuntimeException e) {
            //400エラーのスロー
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid request data");
        }
    }
}
