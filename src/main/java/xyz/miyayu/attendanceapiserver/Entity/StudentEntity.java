package xyz.miyayu.attendanceapiserver.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "students")
@Getter
@Setter
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    @Column(name = "auto_id")
    private int autoId;

    @JsonProperty("studentId")
    @Column(name = "student_id", length = 100)
    private String studentId;

    @JsonProperty("name")
    @Column(name = "name", length = 100)
    private String name;

    @JsonProperty("departmentId")
    @Column(name = "department_id")
    private int departmentId;

    @JsonProperty("icId")
    @Column(name = "ic_id", length = 100)
    private String icId = null;
}
