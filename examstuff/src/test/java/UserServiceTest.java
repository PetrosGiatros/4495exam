import org.junit.Assert;
import org.junit.Test;

public class UserServiceTest {

    UserDb MockUser = new UserDb("root", "Pass3word!?");

    @Test
    public void testIfUserExistsAndIfPasswordIsCorrect() {
        UserService connection = new UserService(MockUser);
        boolean result = connection.changePassword("root", "NewPass!!!6d!");
        Assert.assertTrue(result);
    }

    @Test
    public void testIfUserExistAndPasswordWeak() {
        UserService connection = new UserService(MockUser);
        boolean result = connection.changePassword("root", "testpass");
        Assert.assertFalse(result);
    }

    @Test
    public void testIfUserDoesNotExistAndPasswordCorrect() {
        UserService connection = new UserService(MockUser);
        boolean result = connection.changePassword("serviceLogin", "NewPass!!!6d!");
        Assert.assertFalse(result);
    }
}
