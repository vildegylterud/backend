package backend.controller;


import backend.service.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@PreAuthorize("hasRole('FORELESER')") //ved fjerning av denne gies tilgang, men fra alle roller
@RequestMapping(value = "/admin")
@EnableAutoConfiguration
@CrossOrigin
@RestController
public class AdminController {


    private static final Logger LOGGER = LogManager.getLogger(AdminController.class);

    @GetMapping(value = "")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public String doLoginAdmin(){
        String message = "admin";
        LOGGER.info(message);
        return message;
    }

}
