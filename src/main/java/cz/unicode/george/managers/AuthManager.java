package cz.unicode.george.managers;

import cz.unicode.george.entities.UserEntity;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;

@SessionScoped
public class AuthManager implements Serializable {
    UserEntity loggedUser;
    @Inject
    UserManager userManager;

    public boolean loginUser(UserEntity user) {
        if (userManager.checkCredentials(user)) {
            loggedUser = user;
            return true;
        } else {
            return false;
        }
    }

    public boolean logOf() {
        loggedUser = null;
        return true;
    }

    public boolean isUserLogged() {
        if (loggedUser == null) {
            return false;
        } else {
            return true;
        }
    }

    public UserEntity getLoggedUser() {
        return this.loggedUser;
    }

}
