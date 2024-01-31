package xyz.miyayu.attendanceapiserver.Controller.Response;

import lombok.Data;
import xyz.miyayu.attendanceapiserver.Entity.SubjectEntity;
@Data
public class SubjectResponse {
    public Iterable<SubjectEntity> subjects;
}
