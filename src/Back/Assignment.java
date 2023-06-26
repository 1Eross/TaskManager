package Back;

import Interface.Column;

import java.util.ArrayList;
import java.util.List;

public class Assignment {
    private long id;
    private String title = "Yours new assignment";
    private long project_id;
    private long user_id;

    public long getUser_id() {
        return user_id;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public long getProject_id() {
        return project_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public void setProject_id(long project_id) {
        this.project_id = project_id;
    }

}
