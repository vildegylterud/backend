package backend.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/studass")
@EnableAutoConfiguration
@CrossOrigin
public class StudassController {
    private static final Logger LOGGER = LogManager.getLogger(StudassController.class);
    @GetMapping(value = "")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public String doLoginStudass(){
        String message = "studass";
        LOGGER.info(message);
        return message;
    }

}
