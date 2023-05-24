package Interface;

import Interface.Utilites.Utils;

import javax.swing.*;
import java.awt.*;

public class Column {
    JPanel main = new JPanel(new GridBagLayout());
    JPanel cards = new JPanel();
    JScrollPane scrollPane = new JScrollPane();
    Label title = new Label();
    JButton button = new JButton("***");

    public Column() {

        this.title.setText("[Test alignment]");
        this.Init();
        this.addTask();

    }

    public Column(String Title) {

        this.title.setText(Title);
        this.Init();
        this.addTask();

    }

    private void Init() {

        main.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));
        cards.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));
        button.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));

        title.setAlignment(Label.CENTER);

        GridBagConstraints titleConstraints = new GridBagConstraints();
        titleConstraints.weighty = 0;
        titleConstraints.weightx = 0.5;
        titleConstraints.fill = GridBagConstraints.HORIZONTAL;
        titleConstraints.anchor = GridBagConstraints.NORTH;
        main.add(title, titleConstraints);

        //Cards

        cards.setLayout(new BoxLayout(cards, BoxLayout.Y_AXIS));

        scrollPane.setViewportView(cards);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        GridBagConstraints cardsConstraints = new GridBagConstraints();
        cardsConstraints.weighty = 0.5;
        cardsConstraints.weightx = 0.5;
        cardsConstraints.anchor = GridBagConstraints.CENTER;
        cardsConstraints.fill = GridBagConstraints.BOTH;
        cardsConstraints.gridy = 1;
        main.add(scrollPane, cardsConstraints);

        //Button

        GridBagConstraints buttonConstraints = new GridBagConstraints();
        buttonConstraints.weighty = 0;
        buttonConstraints.weightx = 0.5;
        buttonConstraints.gridy = 2;
        main.add(button, buttonConstraints);

    }

    public void addTask(String title) { //Пока что добавляет Interface.ShortCard, но должен добавлять task

        ShortCard shortCard = new ShortCard(title);
        cards.add(Box.createRigidArea(new Dimension(0,10)));
        cards.add(shortCard.get());


    }

    public void addTask(){
        ShortCard shortCard = new ShortCard();
        cards.add(Box.createRigidArea(new Dimension(0,10)));
        cards.add(shortCard.get());

    }

    public Container get() {

        return main;

    }

}
