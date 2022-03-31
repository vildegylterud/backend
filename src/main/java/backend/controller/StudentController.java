package backend.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/student")
@EnableAutoConfiguration
@CrossOrigin
public class StudentController {
    private static final Logger LOGGER = LogManager.getLogger(StudentController.class);
    @GetMapping(value = "")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public String doLoginStudent(){
        String message = "student";
        LOGGER.info(message);
        return message;
    }

}
