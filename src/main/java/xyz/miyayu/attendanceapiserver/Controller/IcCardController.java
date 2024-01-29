package xyz.miyayu.attendanceapiserver.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xyz.miyayu.attendanceapiserver.Controller.Request.StudentRequest;
import xyz.miyayu.attendanceapiserver.Service.IcCardService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ic")
public class IcCardController {
    private  final IcCardService icCardService;
    @PostMapping("")
    public void update(@RequestBody StudentRequest request) {
        icCardService.updateStudent(request);
    }
}
