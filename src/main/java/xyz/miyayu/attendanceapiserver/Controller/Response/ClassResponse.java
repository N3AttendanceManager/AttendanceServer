package xyz.miyayu.attendanceapiserver.Controller.Response;

import lombok.Data;
import xyz.miyayu.attendanceapiserver.Entity.ClassEntity;
@Data
public class ClassResponse {
    public Iterable<ClassEntity> classes;
}
