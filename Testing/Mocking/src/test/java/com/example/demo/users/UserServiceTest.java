package com.example.demo.users;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock  // Mocking the dependency
    private UserRepository userRepository;

    @InjectMocks // Injecting the mock into service
    private UserService userService;

    private User mockUser;

    @BeforeEach
    void setUp() {
        mockUser = new User(1L, "John Doe", "john@example.com");
    }

    @Test
    void testGetUserByEmail() {
        // Stubbing the repository call
        when(userRepository.findByEmail("john@example.com")).thenReturn(mockUser);

        // Calling the actual service method
        User foundUser = userService.getUserByEmail("john@example.com");

        // Assertions
        assertEquals("John Doe", foundUser.getName());
        assertEquals("john@example.com", foundUser.getEmail());

        // Verify interaction with the mock
        verify(userRepository, times(1)).findByEmail("john@example.com");
    }

    @Test
    void testSaveUser() {
        // Stubbing repository save method
        when(userRepository.save(mockUser)).thenReturn(mockUser);

        User savedUser = userService.saveUser(mockUser);

        assertEquals("John Doe", savedUser.getName());
        verify(userRepository, times(1)).save(mockUser);
    }
}
