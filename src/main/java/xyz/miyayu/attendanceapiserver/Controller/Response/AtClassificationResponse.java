package xyz.miyayu.attendanceapiserver.Controller.Response;

import lombok.Data;
import xyz.miyayu.attendanceapiserver.Entity.AtClassificationEntity;

@Data
public class AtClassificationResponse {
    public Iterable<AtClassificationEntity> atClassifications;
}
