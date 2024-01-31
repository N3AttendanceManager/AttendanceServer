package xyz.miyayu.attendanceapiserver.Controller.Response;

import lombok.Data;
import xyz.miyayu.attendanceapiserver.Entity.StudentEntity;

@Data
public class StudentResponse {
    public Iterable<StudentEntity> students;
}
