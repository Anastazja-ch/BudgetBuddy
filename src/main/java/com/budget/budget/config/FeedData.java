package com.budget.budget.config;

import com.budget.budget.model.User;
import com.budget.budget.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class FeedData implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setId(UUID.fromString("b6709863-7a8a-489d-aaf0-eb7f1fe9ed76"));
        user.setPassword("$2a$10$qXk.JsdmBFq0Qa3jCxnUCuZj0wD8Rcf9j9kRaWtyryCvLO9.MhmNq");
        user.setEnabled(true);
        user.setUsername("doe");
        userRepository.save(user);
    }
}
