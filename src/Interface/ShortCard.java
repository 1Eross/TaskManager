package Interface;

import Interface.Utilites.Utils;

import javax.swing.*;
import java.awt.*;

public class ShortCard {
    private final JPanel body = new JPanel(new GridBagLayout());
    private final JTextPane text = new JTextPane();
    private final JButton button = new JButton("+++");

    public ShortCard(String title) {

        this.text.setText(title);
        this.Init();

    }

    public ShortCard() {

        this.text.setText("[You can write here]");
        this.Init();

    }

    private void Init() {

        body.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));
        button.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));

        /*body.setPreferredSize(new Dimension(270, body.getPreferredSize().height));
        text.setPreferredSize(new Dimension(240, body.getPreferredSize().height));*/
        Utils.setSize(text,240, 50);
        Utils.setSize(body, 270, 80);
        Utils.setSize(button, 30, 30);

        body.setMinimumSize(new Dimension(270,80));

        body.setBackground(Color.LIGHT_GRAY);

        GridBagConstraints titleConstraints = new GridBagConstraints(0,0,3,2,1,1,GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(0,0,0,0), 0, 0);
        text.setEditable(false);
        text.setFocusable(false);
        text.setBackground(Color.WHITE);
        body.add(this.text, titleConstraints);

        GridBagConstraints buttonConstraints = new GridBagConstraints(2, 2, 1, 1, 1, 1, GridBagConstraints.LINE_END, GridBagConstraints.NONE, new Insets(0,0,0,0), 0, 0);
        button.setBackground(Color.WHITE);
        body.add(this.button, buttonConstraints);

    }

    public Container get() {
        return body;
    }
}
