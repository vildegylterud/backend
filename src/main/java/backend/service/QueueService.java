package backend.service;
import backend.controller.QueueController;
import backend.model.Queue;
import backend.repo.QueueRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueueService {

    private static final Logger LOGGER = LogManager.getLogger(QueueController.class);

    private QueueRepo queueRepo;

    public QueueService(QueueRepo queueRepo) {
        this.queueRepo = queueRepo;
    }

    Queue saveQueue(Queue queue) {
        return queueRepo.save(queue);
    }

    public Queue updateQueue(Queue queue, Long queueId) {
        Queue queueDB = queueRepo.findById(queueId).get();

        try{
            queueDB.setQueue_id(queue.getUser_id());
            queueDB.setSubject_id(queue.getSubject_id());
            queueDB.setDate(queue.getDate());
            queueDB.setAssignmentId(queue.getAssignmentId());
            queueDB.setLocation(queue.getLocation());
        } catch (Exception e) {
            LOGGER.info(e.toString());
        }
        return queueRepo.save(queueDB);
    }

    public void deleteQueueById(Long queueId) {
        queueRepo.deleteById(queueId);
    }
}
