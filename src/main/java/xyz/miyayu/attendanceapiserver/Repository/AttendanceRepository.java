package xyz.miyayu.attendanceapiserver.Repository;

import org.springframework.data.repository.CrudRepository;
import xyz.miyayu.attendanceapiserver.Entity.AttendanceEntity;

import java.util.List;

public interface AttendanceRepository extends CrudRepository<AttendanceEntity, Integer> {

    List<AttendanceEntity> findByStudentIdAndClassId(int studentId,int classId);
}
