package xyz.miyayu.attendanceapiserver.Controller.Request;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

@Data
public class StudentRequest{
    private String icId;
    //変数をstudentAutoIdにしているのはフロント側に対してである
    private Integer studentAutoId;
}
