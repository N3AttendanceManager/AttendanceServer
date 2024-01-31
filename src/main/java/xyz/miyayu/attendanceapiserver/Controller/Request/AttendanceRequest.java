package xyz.miyayu.attendanceapiserver.Controller.Request;

import lombok.Data;

@Data
public class AttendanceRequest {
    private Integer studentId;
    private int classId;
    private int atClassificationId;
    private String icId;

}
