package xyz.miyayu.attendanceapiserver.Controller.Request;

import lombok.Data;

@Data
public class StudentRegisterRequest {
    private String studentId;
    private String name;
    private int departmentId;
}
