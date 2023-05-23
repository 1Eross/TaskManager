import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Test Frame");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        Column column1 = new Column();

        Column column2 = new Column("На завтра");
        column2.addTask("Сходить в магазин");
        column2.addTask("Постирать вещи");

        frame.add(column1.get(),BorderLayout.WEST);
        frame.add(column2.get(), BorderLayout.EAST);

        frame.setVisible(true);

    }
}