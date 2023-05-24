package Interface;

import javax.swing.*;
import java.awt.*;

public class Desk {
    JPanel main = new JPanel(new GridBagLayout());
    JPanel body = new JPanel();
    JPanel bar = new JPanel(new GridBagLayout());
    JPanel menu = new JPanel(new GridBagLayout());
    JButton button1 = new JButton("Settings");

    public Desk() {

        this.Init();

    }

    public void Init() {

        main.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.black));
        menu.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.black));
        bar.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.black));
        body.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.black));

        GridBagConstraints menuConstraints = new GridBagConstraints();
        menuConstraints.fill = GridBagConstraints.BOTH;
        menuConstraints.anchor = GridBagConstraints.WEST;
        menuConstraints.gridheight = 2;
        menuConstraints.weighty = 0.50;
        menuConstraints.weightx = 0;
        main.add(menu, menuConstraints);

        bar.add(button1);

        GridBagConstraints barConstraints = new GridBagConstraints();
        barConstraints.gridx = 1;
        barConstraints.gridy = 0;
        barConstraints.fill = GridBagConstraints.BOTH;
        barConstraints.anchor = GridBagConstraints.NORTH;
        barConstraints.weightx = 0.5;
        barConstraints.weighty = 0;
        main.add(bar, barConstraints);


        GridBagConstraints bodyConstraints = new GridBagConstraints();
        bodyConstraints.gridx = 1;
        bodyConstraints.gridy = 1;
        bodyConstraints.fill = GridBagConstraints.BOTH;
        barConstraints.anchor = GridBagConstraints.SOUTH;
        barConstraints.weightx = 0.5;
        barConstraints.weighty = 0.5;
        main.add(body, bodyConstraints);

        body.setLayout(new BoxLayout(body, BoxLayout.X_AXIS));

        main.setVisible(true);
        bar.setVisible(true);
        body.setVisible(true);
        menu.setVisible(true);

    }

    public void addColumn(Column column) {

        body.add(column.get());
        body.add(Box.createRigidArea(new Dimension(10, 0)));

    }

    public Container get() {

        return main;

    }
}
