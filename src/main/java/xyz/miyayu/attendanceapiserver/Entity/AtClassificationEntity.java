package xyz.miyayu.attendanceapiserver.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "at_classifications")
@Getter
@Setter
public class AtClassificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auto_id")
    public int id;

    @Column(name = "school_id")
    public int schoolId;

    @Column(name = "name",length = 100)
    public String name;

    @Column(name = "at_decision")
    public  boolean isDecision = true;

    @Column(name = "class_exclusion_decision")
    public boolean isClassExclusionDecision = false;
}
