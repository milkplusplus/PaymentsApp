package paymentsystem.forms;

import paymentsystem.models.User;

import java.util.Arrays;
import java.util.List;

public class ListUserForm {
    private List<UserRow> list;


    public List<UserRow> getList() {
        return list;
    }

    public void setList(List<UserRow> list) {
        this.list = list;
    }
}
