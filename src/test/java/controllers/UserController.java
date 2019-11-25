package controllers;

import models.User;
import org.springframework.web.client.RestTemplate;

public class UserController {
    private RestTemplate restTemplate;

    private final String API_BASE = "https://api.github.com";

    public UserController() {
        restTemplate = new RestTemplate();
    }

    public User getUserByUsername(String username) {
        try {
            return restTemplate.getForObject(API_BASE + "/users/" + username, User.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public User[] getFollowersByUsername(String username) {
        try {
            return restTemplate.getForObject(API_BASE + "/users/" + username + "/followers", User[].class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
