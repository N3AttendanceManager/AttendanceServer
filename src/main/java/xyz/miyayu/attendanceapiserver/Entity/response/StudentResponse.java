package xyz.miyayu.attendanceapiserver.Entity.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import xyz.miyayu.attendanceapiserver.Entity.StudentEntity;

@Data
public class StudentResponse {
    public Iterable<StudentEntity> students;
}
