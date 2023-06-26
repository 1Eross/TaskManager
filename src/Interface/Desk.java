package Interface;

import Back.Assignment;
import Back.Project;
import Back.Service.AssignmentService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Desk extends JPanel {
    Project project;
    JPanel body = new JPanel();
    JScrollPane scrollPane = new JScrollPane(body);
    JButton createColumnButton = new JButton("Create new Column");
    ActionListener buttonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()){
                case "createColumn":
                    createColumn();
                    addCreateColumnButton();
                    break;
            }
        }
    };

    public Desk(Project project) {

        this.project = project;
        this.Init();
        this.loadColumn(project);
        this.addCreateColumnButton();

    }

    private void Init() {

        /*scrollPane.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.yellow));
        body.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.green));*/

        //This

        this.setLayout(new BorderLayout());

        //Body

        body.setLayout(new BoxLayout(body, BoxLayout.X_AXIS));
        body.add(Box.createHorizontalStrut(10));


        //ScrollPane

        scrollPane.setViewportView(body);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);


        this.add(scrollPane);

        // CreateColumnButton

        createColumnButton.setActionCommand("createColumn");
        createColumnButton.addActionListener(buttonListener);



    }

    private void addColumn(Assignment assignment) {

        body.add(new Column(assignment));
        body.add(Box.createHorizontalStrut(10));

        this.update();


    }

    private void loadColumn(Project project) {

        ArrayList<Assignment> assignmentList = AssignmentService.getAll(project.getId());
        for (Assignment assignment : assignmentList) {
            this.addColumn(assignment);
        }
    }

    private void addCreateColumnButton(){

        body.remove(createColumnButton);
        body.add(createColumnButton, -1);
        this.update();

    }

    private void createColumn(){

        Assignment temp = new Assignment();
        temp.setTitle(JOptionPane.showInputDialog("Введите название для группы задач"));
        temp.setProject_id(project.getId());
        temp.setUser_id(project.getUser_id());
        temp.setId(AssignmentService.set(temp));

        addColumn(temp);

    }

    public void update() {
        this.revalidate();
        this.repaint();
    }
}
