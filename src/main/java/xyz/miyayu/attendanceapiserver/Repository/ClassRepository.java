package xyz.miyayu.attendanceapiserver.Repository;

import org.springframework.data.repository.CrudRepository;
import xyz.miyayu.attendanceapiserver.Entity.ClassEntity;

public interface ClassRepository extends CrudRepository<ClassEntity, Integer> {
}
