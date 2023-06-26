package Interface;

import Back.Assignment;
import Back.Service.TaskService;
import Back.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Column extends JPanel {

    Assignment assignment;
    JPanel cards = new JPanel();
    JScrollPane scrollPane = new JScrollPane(cards);
    Label title = new Label();
    JButton button = new JButton("***");
    JPopupMenu popup = new JPopupMenu();
    ActionListener buttonListener = e -> popup.show();


    public Column(Assignment assignment) {

        this.assignment = assignment;

        this.Init();
        this.title.setText(assignment.getTitle());
        this.loadTask(assignment);
        this.update();

    }

    private void Init() {

        /*main.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        cards.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        button.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));*/

        //Column
        this.setMinimumSize(new Dimension(320, 400));
        this.setPreferredSize(new Dimension(340, 400));
        this.setMaximumSize(new Dimension(340, 900));

        this.setLayout(new GridBagLayout());

        //title

        title.setAlignment(Label.CENTER);

        GridBagConstraints titleConstraints = new GridBagConstraints();
        titleConstraints.weighty = 0;
        titleConstraints.weightx = 0.5;
        titleConstraints.fill = GridBagConstraints.HORIZONTAL;
        titleConstraints.anchor = GridBagConstraints.NORTH;
        this.add(title, titleConstraints);

        //CardsLayout

        BoxLayout cardsLayout = new BoxLayout(cards, BoxLayout.PAGE_AXIS);

        //Cards

        cards.setLayout(cardsLayout);

        scrollPane.setViewportView(cards);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        GridBagConstraints cardsConstraints = new GridBagConstraints();
        cardsConstraints.weighty = 0.5;
        cardsConstraints.weightx = 0.5;
        cardsConstraints.anchor = GridBagConstraints.CENTER;
        cardsConstraints.fill = GridBagConstraints.BOTH;
        cardsConstraints.gridy = 1;
        this.add(scrollPane, cardsConstraints);

        //Button

        button.setBackground(Color.WHITE);
        button.addActionListener(buttonListener);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                popup.show(e.getComponent(), e.getX(), e.getY());
            }
        });

        GridBagConstraints buttonConstraints = new GridBagConstraints();
        buttonConstraints.weighty = 0;
        buttonConstraints.weightx = 0.5;
        buttonConstraints.gridy = 2;
        buttonConstraints.insets = new Insets(5,5,5,5);
        this.add(button, buttonConstraints);

        //popup

        popup.add(new JMenuItem(new AbstractAction("New task") {
            @Override
            public void actionPerformed(ActionEvent e) {
                Column.this.createTask(); //Дописать
            }
        }));

        popup.add(new JMenuItem(new AbstractAction("Edit") {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Editing Column");
            }
        }));

    }

    protected void addTask(Task task){

        cards.add(Box.createVerticalStrut(10));
        cards.add(new ShortCard(task));
        this.update();

    }

    private void loadTask(Assignment assignment){

        ArrayList<Task> taskList = TaskService.getAll(assignment.getId(), assignment.getProject_id());
        for (Task task: taskList) {
            this.addTask(task);
        }


    }

    public void createTask() {

        Task temp = new Task();
        temp.setAssignmentId(assignment.getId());
        temp.setProjectId(assignment.getProject_id());
        temp.setUser_id(assignment.getUser_id());
        temp.setId(TaskService.set(temp)); //вставляем в таблицу получая значение

        addTask(temp);

        Card card = new Card(temp);
        card.show();


    }

    private void update(){

        this.revalidate();
        this.repaint();

    }

}
