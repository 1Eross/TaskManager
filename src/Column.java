import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Column {
    JPanel main = new JPanel();
    JPanel cards = new JPanel();
    Label title = new Label();
    JButton button = new JButton(":");
    ActionListener buttonListener = e -> this.addTask();

    public Column() {

        this.title.setText("[Test alignment]");
        this.Init();
        this.addTask("[Test task]");

    }

    public Column(String Title) {

        this.title.setText(Title);
        this.Init();
        this.addTask("[Test task]");

    }

    private void Init() {

        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        main.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.BLACK));

        button.setBackground(Color.YELLOW);
        button.setMnemonic(KeyEvent.VK_D);
        button.setActionCommand("AddTask");
        button.addActionListener(buttonListener);

        cards.setLayout(new BoxLayout(cards, BoxLayout.Y_AXIS));

        Utils.setSize(cards, 300, 700);
        Utils.setSize(title, 100, 20);
        Utils.setSize(button, 40,40);

        main.add(title);
        main.add(Box.createRigidArea(new Dimension(0, 10)));
        main.add(cards);
        main.add(button);

    }

    public void addTask(String title) { //Пока что добавляет ShortCard, но должен добавлять task

        ShortCard shortCard = new ShortCard(title);
        cards.add(shortCard.get());
        cards.add(Box.createRigidArea(new Dimension(0, 10)));

    }

    public void addTask(){

        ShortCard shortCard = new ShortCard();
        cards.add(shortCard.get());
        cards.add(Box.createRigidArea(new Dimension(0, 10)));

    }

    public Container get() {

        return main;

    }

}
