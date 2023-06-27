package co.devskills.app;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class PingController {

    @GetMapping(value = "/ping")
    @ResponseStatus(HttpStatus.OK)
    public String healthCheck(){
        return "pong";
    }
}
