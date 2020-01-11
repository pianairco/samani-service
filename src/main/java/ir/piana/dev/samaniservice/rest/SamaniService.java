package ir.piana.dev.samaniservice.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SamaniService {
    @GetMapping
    public ResponseEntity sayHello() {
        return ResponseEntity.ok("Hello World!");
    }
}
