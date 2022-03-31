package backend.controller;

import backend.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/login")
@EnableAutoConfiguration
@CrossOrigin
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping(value = "")
    @ResponseStatus(value = HttpStatus.CREATED)
    @CrossOrigin
    public String doLogin(@RequestParam("username") final String username, @RequestParam("password") final String password) {
        return loginService.loginUser(username, password);
    }
}