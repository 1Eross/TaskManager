package Interface;

import Back.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ShortCard extends JPanel {
    private Task task;
    private final JPopupMenu popup = new JPopupMenu("Label");
    private final JTextArea text = new JTextArea();
    ActionListener buttonListener = e -> popup.show();
    private final JButton button = new JButton("++");


    public ShortCard(Task task) {

        this.task = task;
        this.Init();
        this.text.setText(task.getTitle());
        this.update();

    }

    private void Init() {

        //Borders

        /*body.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        button.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));*/


        /*Utils.setSize(text,240, 50);
        Utils.setSize(body, 270, 80);
        Utils.setSize(button, 30, 30);*/


        //Body

        this.setMaximumSize(new Dimension(265, Integer.MAX_VALUE));
        this.setLayout(new GridBagLayout());

        //Text

        text.setEditable(false);
        text.setFocusable(false);
        text.setLineWrap(true);
        text.setBackground(Color.WHITE);

        GridBagConstraints textConstraints = new GridBagConstraints();
        textConstraints.fill = GridBagConstraints.HORIZONTAL;
        textConstraints.anchor = GridBagConstraints.NORTH;
        textConstraints.weighty = 0;
        textConstraints.weightx = 1;
        textConstraints.insets = new Insets(10, 5, 0, 5);
        this.add(this.text, textConstraints);

        //Popup

        popup.add(new JMenuItem(new AbstractAction("Open") {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShortCard.this.open();
            }
        }));

        popup.add(new JMenuItem(new AbstractAction("Complete") {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Card completed");
            }
        }));
        popup.add(new JMenuItem(new AbstractAction("Move") {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Card move");
            }
        }));


        //Button

        button.setMinimumSize(new Dimension(30, 30));

        button.setBackground(Color.WHITE);
        button.addActionListener(buttonListener);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                popup.show(e.getComponent(), e.getX(), e.getY());
            }
        });

        GridBagConstraints buttonConstraints = new GridBagConstraints();
        buttonConstraints.gridy = 1;
        buttonConstraints.weightx = 1;
        buttonConstraints.anchor = GridBagConstraints.LINE_END;
        buttonConstraints.insets = new Insets(0, 0, 0, 5);
        this.add(this.button, buttonConstraints);


    }

    private void open() {
        Card card = new Card(task);
        card.show();
        card.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                task = card.getTask();
                text.setText(task.getTitle());
                ShortCard.this.update();
            }
        });

    }


    public void update() {
        this.revalidate();
        this.repaint();
    }
}
