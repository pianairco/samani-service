package ir.piana.dev.samaniservice.service;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserInfoService {
    private Map<String, List<UserInfo>> userInfosMap;

    @PostConstruct
    public void init() {
        userInfosMap = new LinkedHashMap<>();
    }

    public void addData(String data) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            if(userInfosMap.containsKey(currentUserName)) {
                List<UserInfo> userInfos = userInfosMap.get(currentUserName);
                userInfos.add(new UserInfo(data, new Timestamp(System.currentTimeMillis())));
            } else {
                List<UserInfo> userInfos = new ArrayList<>();
                userInfos.add(new UserInfo(data, new Timestamp(System.currentTimeMillis())));
                userInfosMap.put(currentUserName, userInfos);
            }
        }
    }

    public List<UserInfo> getUserInfos() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            if(userInfosMap.containsKey(currentUserName)) {
                return userInfosMap.get(currentUserName);
            }
        }
        return new ArrayList<>();
    }
}

class UserInfo {
    private String data;
    private Timestamp timestamp;

    public UserInfo(String data, Timestamp timestamp) {
        this.data = data;
        this.timestamp = timestamp;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}