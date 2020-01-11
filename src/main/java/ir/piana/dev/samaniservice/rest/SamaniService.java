package ir.piana.dev.samaniservice.rest;

import ir.piana.dev.samaniservice.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SamaniService {
    @Autowired
    private UserInfoService userInfoService;

    @GetMapping(path = "user/say-hello")
    public ResponseEntity sayHello(@Param("name") String name) {
        String sayTo = name == null || name.isEmpty() ? "World" : name;
        return ResponseEntity.ok("Hello ".concat(sayTo).concat("!"));
    }

    @GetMapping(path = "user/save-data")
    public ResponseEntity saveData(@Param("data") String data) {
        userInfoService.addData(data);
        return ResponseEntity.ok("saved!");
    }

    @GetMapping(path = "user/get-info")
    public ResponseEntity getInfo() {
        return ResponseEntity.ok(userInfoService.getUserInfos());
    }

//    @PostMapping(path = "perform_login")
//    public ResponseEntity performLogin(@RequestParam("username") String username, @RequestParam("password") String password) {
//        return ResponseEntity.ok("Hello"));
//    }
}
