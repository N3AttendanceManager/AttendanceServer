package xyz.miyayu.attendanceapiserver.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "teachers")
@Getter
@Setter
public class TeacherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auto_id")
    private int autoId;

    @Column(name = "teacher_id", length = 100)
    private String teacherId;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "school_id")
    private int schoolId;

    @Column(name = "account_id", length = 100)
    private String accountId;

    @Column(name = "password", length = 100)
    private  String password;
}
