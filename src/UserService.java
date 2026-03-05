import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public class UserService {
    private List<User> userList = new ArrayList<>();
    public void add(User user) {
        userList.add(user);
    }

    public Optional<User> findByID(int id) {
        for(User u : userList) {
            if (u.getID() == id) {
                return Optional.of(u);
            }
        }
        return Optional.empty();
    }
    public List<User> findAll() {
        return this.userList;
    }
}
