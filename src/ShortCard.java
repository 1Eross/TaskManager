import javax.swing.*;
import java.awt.*;

public class ShortCard {
    private final JPanel body = new JPanel(new GridBagLayout());
    private final JTextPane title = new JTextPane();
    private final JButton button = new JButton();

    public ShortCard(String title) {

        this.title.setText(title);
        this.Init();

    }

    public ShortCard() {

        this.title.setText("[You can write here]");
        this.Init();

    }

    private void Init() {

        Utils.setSize(title, 240, 50);
        Utils.setSize(body, 270, 80);
        Utils.setSize(button, 30, 30);

        body.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        body.setBackground(Color.LIGHT_GRAY);

        GridBagConstraints titleConstraints = new GridBagConstraints(0,0,3,2,1,1,GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(0,0,0,0), 0, 0);
        title.setEditable(false);
        title.setFocusable(false);
        title.setBackground(Color.WHITE);
        body.add(this.title, titleConstraints);

        GridBagConstraints buttonConstraints = new GridBagConstraints(2, 2, 1, 1, 1, 1, GridBagConstraints.LINE_END, GridBagConstraints.NONE, new Insets(0,0,0,0), 0, 0);
        button.setBackground(Color.WHITE);
        body.add(this.button, buttonConstraints);

    }

    public JPanel get() {
        return body;
    }
}
