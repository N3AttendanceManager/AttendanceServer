package xyz.miyayu.attendanceapiserver.Repository;

import org.springframework.data.repository.CrudRepository;
import xyz.miyayu.attendanceapiserver.Entity.StudentEntity;

public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {
}
