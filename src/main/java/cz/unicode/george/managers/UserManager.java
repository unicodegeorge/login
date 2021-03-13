package cz.unicode.george.managers;

import cz.unicode.george.entities.UserEntity;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;

@ApplicationScoped
public class UserManager {
    ArrayList<UserEntity> users = new ArrayList<>();

    public boolean checkCredentials(UserEntity user) {
        return users.stream()
                .anyMatch(s -> s.getUsername().equals( user.getUsername()) && s.getPassword().equals(user.getPassword()));
    }

    public boolean doesUserExist(UserEntity user) {
        return users.stream()
                .anyMatch(s -> s.getUsername().equals(user.getUsername()));
    }

    public boolean registerUser(UserEntity user) {
        if (!doesUserExist(user)) {
            users.add(user);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<UserEntity> getAllUsers() {
        return this.users;
    }
}
