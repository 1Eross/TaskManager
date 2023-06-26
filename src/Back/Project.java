package Back;

import Interface.Desk;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private long id;
    private String title = "Yours new project";
    private long user_id;
    private Desk desk;

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public long getUser_id() {
        return user_id;
    }

}
