package xyz.miyayu.attendanceapiserver.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "attendances")
@Getter
@Setter
public class AttendanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auto_id")
    private int autoId;

    @Column(name = "student_id")
    private int studentId;

    @Column(name = "class_id")
    private int classId;

    @Column(name = "teacher_id")
    private int teacherId;

    @Column(name = "at_classification_id")
    private int atClassificationId;

}
