package xyz.miyayu.attendanceapiserver.Controller.Request;

import lombok.Data;

@Data
public class ClassRequest {
    private int subjectId;
    private String startOn;
    private String endOn;
}
