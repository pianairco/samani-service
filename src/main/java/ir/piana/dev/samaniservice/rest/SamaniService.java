package ir.piana.dev.samaniservice.rest;

import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class SamaniService {
    @GetMapping(path = "user/say-hello")
    public ResponseEntity sayHello(@Param("name") String name) {
        String sayTo = name == null || name.isEmpty() ? "World" : name;
        return ResponseEntity.ok("Hello ".concat(sayTo).concat("!"));
    }

//    @PostMapping(path = "perform_login")
//    public ResponseEntity performLogin(@RequestParam("username") String username, @RequestParam("password") String password) {
//        return ResponseEntity.ok("Hello"));
//    }
}
