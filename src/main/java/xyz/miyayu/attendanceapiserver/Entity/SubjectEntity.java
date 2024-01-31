package xyz.miyayu.attendanceapiserver.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "subjects")
@Getter
@Setter
public class SubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auto_id")
    private int id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "department_id")
    private int departmentId;

}
