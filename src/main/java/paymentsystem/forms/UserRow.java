package paymentsystem.forms;

import paymentsystem.models.User;

public class UserRow {
    boolean checkControl = true; //default true
    User user;

    public UserRow( User user) {
        this.user = user;
    }

    public boolean isCheckControl() {
        return checkControl;
    }

    public void setCheckControl(boolean checkControl) {
        this.checkControl = checkControl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
