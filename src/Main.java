import Interface.Column;
import Interface.Desk;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Test Frame");

        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        Desk test = new Desk();
        Column column1 = new Column();
        column1.addTask("Used when the component's display area is larger than the component's requested size to determine whether and how to resize the component. Valid values (defined as GridBagConstraints constants) include NONE (the default), HORIZONTAL (make the component wide enough to fill its display area horizontally, but do not change its height), VERTICAL (make the component tall enough to fill its display area vertically, but do not change its width), and BOTH (make the component fill its display area entirely).\n" +
                "ipadx, ipady");
        column1.addTask("Used when the component's display area is larger than the component's requested size to determine whether and how to resize the component. Valid values (defined as GridBagConstraints constants) include NONE (the default), HORIZONTAL (make the component wide enough to fill its display area horizontally, but do not change its height), VERTICAL (make the component tall enough to fill its display area vertically, but do not change its width), and BOTH (make the component fill its display area entirely).\n" +
                "ipadx, ipady");
        column1.addTask("Used when the component's display area is larger than the component's requested size to determine whether and how to resize the component. Valid values (defined as GridBagConstraints constants) include NONE (the default), HORIZONTAL (make the component wide enough to fill its display area horizontally, but do not change its height), VERTICAL (make the component tall enough to fill its display area vertically, but do not change its width), and BOTH (make the component fill its display area entirely).\n" +
                "ipadx, ipady");
        column1.addTask("Used when the component's display area is larger than the component's requested size to determine whether and how to resize the component. Valid values (defined as GridBagConstraints constants) include NONE (the default), HORIZONTAL (make the component wide enough to fill its display area horizontally, but do not change its height), VERTICAL (make the component tall enough to fill its display area vertically, but do not change its width), and BOTH (make the component fill its display area entirely).\n" +
                "ipadx, ipady");
        column1.addTask("Used when the component's display area is larger than the component's requested size to determine whether and how to resize the component. Valid values (defined as GridBagConstraints constants) include NONE (the default), HORIZONTAL (make the component wide enough to fill its display area horizontally, but do not change its height), VERTICAL (make the component tall enough to fill its display area vertically, but do not change its width), and BOTH (make the component fill its display area entirely).\n" +
                "ipadx, ipady");
        column1.addTask("Used when the component's display area is larger than the component's requested size to determine whether and how to resize the component. Valid values (defined as GridBagConstraints constants) include NONE (the default), HORIZONTAL (make the component wide enough to fill its display area horizontally, but do not change its height), VERTICAL (make the component tall enough to fill its display area vertically, but do not change its width), and BOTH (make the component fill its display area entirely).\n" +
                "ipadx, ipady");
        column1.addTask("Used when the component's display area is larger than the component's requested size to determine whether and how to resize the component. Valid values (defined as GridBagConstraints constants) include NONE (the default), HORIZONTAL (make the component wide enough to fill its display area horizontally, but do not change its height), VERTICAL (make the component tall enough to fill its display area vertically, but do not change its width), and BOTH (make the component fill its display area entirely).\n" +
                "ipadx, ipady");
        column1.addTask("Used when the component's display area is larger than the component's requested size to determine whether and how to resize the component. Valid values (defined as GridBagConstraints constants) include NONE (the default), HORIZONTAL (make the component wide enough to fill its display area horizontally, but do not change its height), VERTICAL (make the component tall enough to fill its display area vertically, but do not change its width), and BOTH (make the component fill its display area entirely).\n" +
                "ipadx, ipady");

        test.addColumn(column1);
        Column column2 = new Column();
        test.addColumn(column2);
        Column column3 = new Column();
        test.addColumn(column3);

        frame.add(test.get());
        frame.show();
    }
}