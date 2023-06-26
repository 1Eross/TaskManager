import Interface.Column;
import Interface.Desk;
import Interface.MainWindow;
import Interface.Registration;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        AppController taskManager = new AppController();
        taskManager.Start();

     }
}