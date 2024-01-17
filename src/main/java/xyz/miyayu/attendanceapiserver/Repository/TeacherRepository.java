package xyz.miyayu.attendanceapiserver.Repository;

import org.springframework.data.repository.CrudRepository;
import xyz.miyayu.attendanceapiserver.Entity.TeacherEntity;

public interface TeacherRepository extends CrudRepository<TeacherEntity, Integer> {
}
