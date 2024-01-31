package xyz.miyayu.attendanceapiserver.Controller.Response;

import lombok.Data;
import xyz.miyayu.attendanceapiserver.Entity.TeacherEntity;

@Data
public class TeacherResponse {
    public Iterable<TeacherEntity> teachers;
}
