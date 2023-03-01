package Test;

import controller.Login.LoginImplement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LoginControllerTest {
    private static LoginImplement loginImplement;

    @BeforeAll
    public static void setup() {
        loginImplement = new LoginImplement();
    }

    @Test
    public void testValidLogin() {
        boolean result = loginImplement.LoginAuthenticate("user1", "password1");
        Assertions.assertTrue(result);
        Assertions.assertTrue(loginImplement.isLoggedIn());
    }

    @Test
    public void testInvalidUsername() {
        boolean result = loginImplement.LoginAuthenticate("invalid", "password1");
        Assertions.assertFalse(result);
        Assertions.assertFalse(loginImplement.isLoggedIn());
    }

    @Test
    public void testInvalidPassword() {
        boolean result = loginImplement.LoginAuthenticate("user1", "invalid");
        Assertions.assertFalse(result);
        Assertions.assertFalse(loginImplement.isLoggedIn());
    }
}
