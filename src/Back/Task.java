package Back;

import Interface.Card;
import Interface.ShortCard;

public class Task {
    private long id;
    private String title = "Title here";
    private String description = "Description here";
    private int priority;
    private long taskDate;
    private boolean status;
    private long assignmentId;
    private long projectId;
    private long user_id;

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setTaskDate(long taskDate) {
        this.taskDate = taskDate;
    }

    public void setStatus(boolean status){
        this.status = status;
    }

    public void setAssignmentId(long assignmentId) {
        this.assignmentId = assignmentId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
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

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public long getTaskDate() {
        return taskDate;
    }

    public long getAssignmentId() {
        return assignmentId;
    }

    public long getProjectId() {
        return projectId;
    }

    public long getUser_id() {
        return user_id;
    }

    public boolean getStatus() {
        return status;
    }
}
