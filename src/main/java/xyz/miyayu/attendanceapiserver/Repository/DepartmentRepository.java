package xyz.miyayu.attendanceapiserver.Repository;

import org.springframework.data.repository.CrudRepository;
import xyz.miyayu.attendanceapiserver.Entity.DepartmentEntity;

public interface DepartmentRepository extends CrudRepository<DepartmentEntity,Integer> {
}
