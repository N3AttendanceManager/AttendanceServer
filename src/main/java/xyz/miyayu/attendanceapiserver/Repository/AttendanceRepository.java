package xyz.miyayu.attendanceapiserver.Repository;

import org.springframework.data.repository.CrudRepository;
import xyz.miyayu.attendanceapiserver.Entity.AttendanceEntity;

public interface AttendanceRepository extends CrudRepository<AttendanceEntity, Integer> {
}
