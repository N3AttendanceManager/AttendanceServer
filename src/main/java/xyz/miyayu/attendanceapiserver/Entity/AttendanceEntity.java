package xyz.miyayu.attendanceapiserver.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "attendances")
@Getter
@Setter
@IdClass(value = AttendanceEntity.AttendanceKey.class)
public class AttendanceEntity {

    @Id

    @Column(name = "student_id")
    private int studentId;

    @Id
    @Column(name = "class_id")
    private int classId;

    @Column(name = "teacher_id")
    private int teacherId;

    @Column(name = "at_classification_id")
    private int atClassificationId;


    @Data
    public static class AttendanceKey implements Serializable {
         private int studentId;
         private int classId;
    }
}
