package backend.model;


import javax.persistence.*;

@Entity
@Table(name = "assignment")
public class Assignment {
    @Id
    @Column(name = "assignment_id", nullable = false)
    private Long assignment_id;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "subject_id", nullable = false)
    private Long subject_id;

    @Column(name = "assignment_num", nullable = false)
    private int assignmentNum;

    public Long getAssignment_id() {
        return assignment_id;
    }

    public void setAssignment_id(Long assignment_id) {
        this.assignment_id = assignment_id;
    }
}