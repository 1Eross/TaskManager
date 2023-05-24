package Interface.Utilites;

import java.awt.*;

public class Utils {
    public static void setSize(Component component, int width, int height){

        component.setMaximumSize(new Dimension(width,height));
        component.setPreferredSize(new Dimension(width,height));
        component.setMinimumSize(new Dimension(width,height));

    }
    public static void setSize(Component component, int minWidth, int minHeight, int prefWidth ,int prefHeight){
        component.setMinimumSize(new Dimension(minWidth,minHeight));
        component.setPreferredSize(new Dimension(prefWidth,prefHeight));
    }
}
