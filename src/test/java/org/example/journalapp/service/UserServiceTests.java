package org.example.journalapp.service;


import org.example.journalapp.entity.User;
import org.example.journalapp.repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @ParameterizedTest
    @Disabled
    @ArgumentsSource(UserArgumentsProvider.class)
    public void testSaveNewUser(User user){
        assertTrue(userService.saveNewUser(user));

    }

    @Disabled
    @ParameterizedTest
    @ValueSource(strings={
            "1,1,2",
            "2,10,12",
            "3,3,9"
    })
    public void test(int a, int b, int expected){
        assertEquals(expected, a + b);
    }
}
