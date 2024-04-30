import TestUser.AuthenticationService;
import TestUser.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.security.sasl.AuthenticationException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuthenticationServiceTest {
    private AuthenticationService authenticationService;

    @BeforeEach
    public void setUp() {
        authenticationService = new AuthenticationService();
        authenticationService.addUser(new User("Livar", "password1"));
        authenticationService.addUser(new User("Natali", "password2"));
    }

    @Test
    public void testLoginSuccess() throws AuthenticationException, AuthenticationException {
        assertTrue(authenticationService.login("Livar", "password1"));
    }

    @Test
    public void testLogingFailureIncorrectPassword() {
        assertThrows(AuthenticationException.class, () -> {
            authenticationService.login("Livar", "wrongPassword");
        });
    }

    @Test
    public void testLoginFailureUserNotFound() {
        assertThrows(AuthenticationException.class, () -> {
            authenticationService.login("NoExistentUser", "password");
        });
    }
}
