package Interface;

import Back.Service.TaskService;
import Back.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Card extends JFrame {
    Task task;
    private final JTextField title = new JTextField("TEST TITLE");
    private final JLabel underTitle = new JLabel("UNDER_TITLE");
    private final JTextPane description = new JTextPane();
    private final JButton close = new JButton("Close");
    private final JButton accept = new JButton("Accept");
    private final ActionListener actionListener = e -> {
        switch (e.getActionCommand()){
            case "accept":
                taskUpdate();
                Card.this.setVisible(false);
                Card.this.dispose();
                Card.this.revalidate();
                break;
            case "close":
                Card.this.setVisible(false);
                Card.this.dispose();
                Card.this.revalidate();
                break;
        }
    };

    public Card(Task task) {

        this.task = task;
        this.title.setText(task.getTitle());
        this.underTitle.setText("In column #" + task.getAssignmentId()); // Поменять на title
        this.description.setText(task.getDescription());

        this.Init();

    }


    private void Init() {

        //ScreenSize
        Dimension screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());

        //Frame

        this.setSize(new Dimension(screenSize.width/2, screenSize.height/2));
        this.setLocationRelativeTo(null);

        this.setLayout(new GridBagLayout());


        //Title

        title.setFont(new Font("Arial", Font.PLAIN, 26));

        GridBagConstraints titleConstraints = new GridBagConstraints();
        titleConstraints.gridwidth = 3;
        titleConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
        titleConstraints.weightx = 0.5;
        titleConstraints.fill = GridBagConstraints.BOTH;
        titleConstraints.insets = new Insets(10, 10, 5, 10);
        this.add(title, titleConstraints);

        //UnderTitle

        GridBagConstraints underTitleConstraints = new GridBagConstraints();
        underTitleConstraints.gridwidth = 2;
        underTitleConstraints.gridy = 1;
        underTitleConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
        underTitleConstraints.insets = new Insets(5,10,5,10);
        this.add(underTitle, underTitleConstraints);


        //Description

        description.setFont(new Font("Arial", Font.PLAIN, 16));
        description.setText("TEST_DESCRIPTION");

        GridBagConstraints descriptionConstraints = new GridBagConstraints();
        descriptionConstraints.gridy = 2;
        descriptionConstraints.gridheight = 4;
        descriptionConstraints.gridwidth = 4;
        descriptionConstraints.fill = GridBagConstraints.BOTH;
        descriptionConstraints.weighty = 0.5;
        descriptionConstraints.weightx = 0.5;
        descriptionConstraints.insets = new Insets(5,10,5,10);
        this.add(description, descriptionConstraints);


        //CloseButton

        close.setActionCommand("close");
        close.addActionListener(actionListener);

        GridBagConstraints closeConstraints = new GridBagConstraints();
        closeConstraints.gridwidth = 2;
        closeConstraints.gridy = 6;
        closeConstraints.gridx = 2;
        closeConstraints.anchor = GridBagConstraints.LINE_START;
        closeConstraints.insets = new Insets(5,10,10,10);
        this.add(close, closeConstraints);

        //AcceptButton

        accept.setActionCommand("accept");
        accept.addActionListener(actionListener);

        GridBagConstraints acceptConstraints = new GridBagConstraints();
        acceptConstraints.gridwidth = 2;
        acceptConstraints.gridy = 6;
        acceptConstraints.gridx = 0;
        acceptConstraints.anchor = GridBagConstraints.CENTER;
        acceptConstraints.insets = new Insets(5,10,10,10);
        this.add(accept, acceptConstraints);

    }

    private void taskUpdate(){

        Task temp = new Task();
        temp.setId(task.getId());
        temp.setTitle(title.getText());
        temp.setDescription(description.getText());
        /*temp.setPriority();*/
        /*temp.setTaskDate();*/
        /*temp.setStatus();*/
        temp.setAssignmentId(task.getAssignmentId());
        temp.setProjectId(task.getProjectId());
        temp.setUser_id(task.getUser_id());
        TaskService.update(temp);
        task = temp;

    }

    public Task getTask(){
        return task;
    }
}
