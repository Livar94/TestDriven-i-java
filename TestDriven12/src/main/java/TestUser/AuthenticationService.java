package TestUser;



import javax.security.sasl.AuthenticationException;
import java.util.ArrayList;
import java.util.List;

public class AuthenticationService {
    private List<User> usersDatabase = new ArrayList<>();

    public void addUser(User user) {
        usersDatabase.add(user);
    }

    public boolean login(String username, String password) throws AuthenticationException {
        for (User user : usersDatabase) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        throw new AuthenticationException("Inloggningen misslyckas. Användarnamn eller Lösenordet är fel");
    }
}
