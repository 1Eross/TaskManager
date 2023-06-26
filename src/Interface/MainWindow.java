package Interface;

import Back.CurrentUser;
import Back.Project;
import Back.Service.ProjectService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static javax.swing.JOptionPane.showInputDialog;

public class MainWindow extends JFrame {
    JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
    JPanel bar = new JPanel(new GridBagLayout());
    JButton settingsButton = new JButton("Settings");
    JButton addDeskButton = new JButton("Add Desk");
    ActionListener buttonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()){
                case "createDesk":
                    deskCreate();
                    break;
                case "openSettings":
                    JOptionPane.showMessageDialog(null, "Вы открыли настройки");
                    break;
            }
        }
    };

    public MainWindow() {

        this.Init();
        projectLoad();
        this.update();

    }

    public void Init() {

        /*menu.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
        bar.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));*/
        /*body.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));*/

        //This

        this.setLayout(new GridBagLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        //Bar

            // AddDeskButton

        addDeskButton.setActionCommand("createDesk");
        addDeskButton.addActionListener(buttonListener);

        GridBagConstraints addDeskButtonConstraints = new GridBagConstraints();
        addDeskButtonConstraints.weighty = 0.5;
        addDeskButtonConstraints.anchor = GridBagConstraints.WEST;
        addDeskButtonConstraints.fill = GridBagConstraints.HORIZONTAL;
        addDeskButtonConstraints.insets = new Insets(10,10,10,10);
        bar.add(addDeskButton, addDeskButtonConstraints);


            // Settings Button

        settingsButton.setActionCommand("openSettings");
        settingsButton.addActionListener(buttonListener);

        GridBagConstraints barButtonConstraints = new GridBagConstraints();
        barButtonConstraints.gridx = 1;
        barButtonConstraints.weighty = 0.5;
        barButtonConstraints.anchor = GridBagConstraints.CENTER;
        barButtonConstraints.insets = new Insets(10, 10, 10, 10);
        bar.add(settingsButton, barButtonConstraints);

            //

        GridBagConstraints barConstraints = new GridBagConstraints();
        barConstraints.gridy = 0;
        barConstraints.fill = GridBagConstraints.BOTH;
        barConstraints.anchor = GridBagConstraints.NORTH;
        barConstraints.weightx = 0.5;
        barConstraints.weighty = 0;
        this.add(bar, barConstraints);

        // TabbedPane

        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

        GridBagConstraints tabPaneConstraints = new GridBagConstraints();
        tabPaneConstraints.gridy = 1;
        tabPaneConstraints.fill = GridBagConstraints.BOTH;
        tabPaneConstraints.anchor = GridBagConstraints.SOUTH;
        tabPaneConstraints.weightx = 0.5;
        tabPaneConstraints.weighty = 0.5;
        this.add(tabbedPane, tabPaneConstraints);



    }

    private void addDesk(Project project){

        tabbedPane.addTab(project.getTitle(), new Desk(project));
        this.update();

    }

    private void projectLoad() {

        ArrayList<Project> projectList = ProjectService.getAll();
        for (Project project : projectList) {
            this.addDesk(project);
        }

    }

    private void deskCreate(){

        Project temp = new Project();
        temp.setUser_id(CurrentUser.getId());
        temp.setTitle(JOptionPane.showInputDialog("Введите название новой доски задач"));

        ProjectService.set(temp);
        addDesk(ProjectService.get(temp)); //Отправляю запрос в БД, чтобы получить только id (плохо?)

    }

    public void update() {

        tabbedPane.revalidate();
        tabbedPane.repaint();

    }
}
