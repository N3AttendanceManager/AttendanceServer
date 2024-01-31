package xyz.miyayu.attendanceapiserver.Controller.Response;

import lombok.Data;
import xyz.miyayu.attendanceapiserver.Entity.AttendanceEntity;

@Data
public class AttendanceResponse {
    public Iterable<AttendanceEntity> attendances;
}
