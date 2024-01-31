package xyz.miyayu.attendanceapiserver.Repository;

import org.springframework.data.repository.CrudRepository;
import xyz.miyayu.attendanceapiserver.Entity.AttendanceEntity;

import java.util.List;
import java.util.Optional;

public interface AttendanceRepository extends CrudRepository<AttendanceEntity, Integer> {

    Optional<AttendanceEntity> findByStudentIdAndClassId(int studentId, int classId);
}
