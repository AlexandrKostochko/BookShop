package storage;

import model.Role;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUserStorage {

    private static List<User> users = new ArrayList<>();
    private static int idUser = 1;

    static {
        users.add(new User("Admin", "admin", "admin", Role.ADMIN));
    }

    public void save(User user) {
        user.setIdUser(idUser);
        idUser++;
        users.add(user);
    }

    public User getByLogin(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    public boolean reg(String login) {
        for (int i = 0; i < users.size(); i++) {
            if (login.equals(users.get(i).getLogin())) {
                return false;
            }
        }
        return true;
    }
}
