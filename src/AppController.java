import Back.CurrentUser;
import Back.Service.Database;
import Interface.MainWindow;
import Interface.Registration;

public class AppController {
    public void Start(){
        Database.Init();
        registrationProcess();
        mainWindowProcess();
        Database.Close();
    }
    public void registrationProcess(){
        Registration registration = new Registration();
        registration.setVisible(true);
        while(CurrentUser.getId() == -1) {
            registration.repaint();
        }
        registration.revalidate();
    }
    public void mainWindowProcess(){
        MainWindow mainWindow = new MainWindow();
        mainWindow.show();
        /*while (mainWindow.isEnabled()){
            mainWindow.update();
        }*/
    }
}
