package xyz.miyayu.attendanceapiserver.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "departments")
@Getter
@Setter
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auto_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "school_id")
    private int schoolId;
}
