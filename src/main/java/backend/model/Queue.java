package backend.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "queue")
@IdClass(QueueId.class)
public class Queue {

    @Id
    @Column(name = "queue_id", nullable = false)
    private Long queue_id;

    public Long getQueue_id() {
        return queue_id;
    }

    public void setQueue_id(Long id) {
        this.queue_id = id;
    }

    @Id
    @Column(name = "user_id", nullable = false)
    private Long user_id;

    @Id
    @Column(name = "subject_id", nullable = false)
    private Long subject_id;

    private Date date;
    private String location;

    @Column(name = "assignment_id")
    private Long assignment_id;

    public Long getAssignmentId() {
        return assignment_id;
    }

    public void setAssignmentId(Long assignmentId) {
        this.assignment_id = assignmentId;
    }

    public Long getUser_id() {
        return user_id;
    }

    public Long getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(Long subject_id) {
        this.subject_id = subject_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
