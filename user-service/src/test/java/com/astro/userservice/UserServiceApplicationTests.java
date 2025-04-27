package com.astro.userservice;

import com.astro.userservice.model.User;
import com.astro.userservice.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class UserServiceApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testCreateUser() {
        User user = User.builder()
                .fullName("Jyoti Vikas")
                .email("jyoti@example.com")
                .gender("Female")
                .dateOfBirth("1997-08-15")
                .birthTime("03:45 AM")
                .birthPlace("Delhi")
                .build();

        User created = userRepository.save(user);

        Assertions.assertNotNull(created.getId());
        Assertions.assertEquals("Jyoti Vikas", created.getFullName());
    }

    @Test
    void testFindUserById() {
        User user = User.builder()
                .fullName("Rahul Sharma")
                .email("rahul@example.com")
                .gender("Male")
                .dateOfBirth("1990-01-01")
                .birthTime("10:00 AM")
                .birthPlace("Mumbai")
                .build();

        User saved = userRepository.save(user);
        Optional<User> found = userRepository.findById(saved.getId());

        Assertions.assertTrue(found.isPresent());
        Assertions.assertEquals("Rahul Sharma", found.get().getFullName());
    }

    @Test
    void testUpdateUser() {
        User user = User.builder()
                .fullName("Anjali Mehta")
                .email("anjali@example.com")
                .gender("Female")
                .dateOfBirth("1985-05-05")
                .birthTime("06:30 PM")
                .birthPlace("Chennai")
                .build();

        User saved = userRepository.save(user);
        saved.setFullName("Anjali Sharma");
        saved.setBirthPlace("Bangalore");

        User updated = userRepository.save(saved);

        Assertions.assertEquals("Anjali Sharma", updated.getFullName());
        Assertions.assertEquals("Bangalore", updated.getBirthPlace());
    }

    @Test
    void testDeleteUser() {
        User user = User.builder()
                .fullName("Delete Me")
                .email("delete@example.com")
                .gender("Other")
                .dateOfBirth("2000-01-01")
                .birthTime("12:00 AM")
                .birthPlace("Unknown")
                .build();

        User saved = userRepository.save(user);
        Long id = saved.getId();
        userRepository.deleteById(id);

        Optional<User> deleted = userRepository.findById(id);
        Assertions.assertFalse(deleted.isPresent());
    }
}
