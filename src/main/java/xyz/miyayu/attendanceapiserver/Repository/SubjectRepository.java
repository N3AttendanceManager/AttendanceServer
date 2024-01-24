package xyz.miyayu.attendanceapiserver.Repository;

import org.springframework.data.repository.CrudRepository;
import xyz.miyayu.attendanceapiserver.Entity.SubjectEntity;

public interface SubjectRepository extends CrudRepository<SubjectEntity, Integer> {
}
