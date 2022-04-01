package backend.controller;


import backend.model.Queue;
import backend.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
@CrossOrigin
public class QueueController {

    @Autowired
    private QueueService queueService;

    // Update operation
    @PutMapping("/queues/{id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    @CrossOrigin
    public Queue updateUser(@RequestBody Queue queue,
               @PathVariable("id") Long queue_id)
    {
        return queueService.updateQueue(
                queue, queue_id);
    }

    // Delete operation
    @DeleteMapping("/queues/{id}")
    public String deleteQueueById(@PathVariable("id")
                                          Long queue_id)
    {
        queueService.deleteQueueById(
                queue_id);
        return "Deleted Successfully";
    }

}
