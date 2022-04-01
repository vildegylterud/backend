package backend.repo;

import backend.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SubjectRepo extends JpaRepository<Subject, Long> {

}
