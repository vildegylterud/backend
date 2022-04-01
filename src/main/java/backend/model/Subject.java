package backend.model;
import javax.persistence.*;


@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @Column(name = "subject_id", nullable = false)
    private Long subject_id;

    public Long getAssignmentId() {
        return assignment_id;
    }

    public void setAssignmentId(Long assignmentId) {
        this.assignment_id = assignmentId;
    }

    @Column(name = "assignment_id")
    private Long assignment_id;


    public String getSubject_name() {
        return subject_name;
    }

    private String subject_name;

    public Long getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(Long subject_id) {
        this.subject_id = subject_id;
    }



}
