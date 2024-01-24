package xyz.miyayu.attendanceapiserver.Repository;

import org.springframework.data.repository.CrudRepository;
import xyz.miyayu.attendanceapiserver.Entity.AtClassificationEntity;

public interface AtClassificationRepository extends CrudRepository<AtClassificationEntity, Integer> {
}
