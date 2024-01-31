package xyz.miyayu.attendanceapiserver.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "classes")
@Getter
@Setter
public class ClassEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auto_Id")
    private int id;

    @Column(name = "subject_id")
    private int subjectId;

    @Column(name = "start_on")
    private LocalDateTime startOn;

    @Column(name = "end_on")
    private LocalDateTime endOn;
}
