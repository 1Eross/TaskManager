package Interface;

import Back.CurrentUser;
import Back.Service.UserService;
import Back.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Registration extends JFrame {
    JLabel title = new JLabel("Authorization");
    JLabel loginTitle = new JLabel("Login");
    JTextField loginField = new JTextField();
    JLabel passwordTitle = new JLabel("Password");
    JTextField passwordField = new JTextField();
    JLabel emailTitle = new JLabel("Email");
    JTextField emailField = new JTextField();
    JButton acceptButton = new JButton("Accept");
    JButton registrationButton = new JButton("Registration");
    boolean isAuthorization;
    ActionListener actionListener = e -> {
        switch (e.getActionCommand()) {
            case "registrationAccept":

                Registration.this.registrationAccept();
                break;

            case "authorizationAccept":

                int id = UserService.check(this.loginField.getText(), this.passwordField.getText());
                Registration.this.authorizationAccept(id);
                break;

            case "change":

                Registration.this.ChangeScreen();
                break;
        }
    };

    public Registration() {

        this.Init();

    }

    private void Init() {

        isAuthorization = true;

        //Frame

        this.setLayout(new GridBagLayout());

        Dimension screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
        this.setSize(new Dimension(screenSize.width / 2, screenSize.height / 2));
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.EXIT_ON_CLOSE);

        this.setTitle("Task Manager");

        //title

        title.setFont(new Font("Arial", Font.PLAIN, 16));

        GridBagConstraints titleConstraints = new GridBagConstraints();
        titleConstraints.gridwidth = 2;
        titleConstraints.insets = new Insets(10, 10, 10, 10);
        titleConstraints.anchor = GridBagConstraints.CENTER;
        this.add(title, titleConstraints);

        //login title

        GridBagConstraints loginTitleConstraints = new GridBagConstraints();
        loginTitleConstraints.gridy = 1;
        loginTitleConstraints.gridwidth = 2;
        loginTitleConstraints.insets = new Insets(10, 10, 10, 10);
        loginTitleConstraints.anchor = GridBagConstraints.CENTER;
        this.add(loginTitle, loginTitleConstraints);

        //loginField


        GridBagConstraints loginConstraints = new GridBagConstraints();
        loginConstraints.gridy = 2;
        loginConstraints.gridwidth = 2;
        loginConstraints.fill = GridBagConstraints.HORIZONTAL;
        loginConstraints.weightx = 0.5;
        loginConstraints.insets = new Insets(10, 10, 10, 10);
        loginConstraints.anchor = GridBagConstraints.CENTER;
        this.add(loginField, loginConstraints);


        //passwordTitle

        GridBagConstraints passwordTitleConstraints = new GridBagConstraints();
        passwordTitleConstraints.gridy = 3;
        passwordTitleConstraints.gridwidth = 2;
        passwordTitleConstraints.insets = new Insets(10, 10, 10, 10);
        passwordTitleConstraints.anchor = GridBagConstraints.CENTER;
        this.add(passwordTitle, passwordTitleConstraints);

        //PasswordField

        GridBagConstraints passwordConstraints = new GridBagConstraints();
        passwordConstraints.gridy = 4;
        passwordConstraints.gridwidth = 2;
        passwordConstraints.weightx = 0.5;
        passwordConstraints.fill = GridBagConstraints.HORIZONTAL;
        passwordConstraints.insets = new Insets(10, 10, 10, 10);
        passwordConstraints.anchor = GridBagConstraints.CENTER;
        this.add(passwordField, passwordConstraints);

        //AcceptButton

        acceptButton.setActionCommand("authorizationAccept");
        acceptButton.addActionListener(actionListener);

        GridBagConstraints acceptConstraints = new GridBagConstraints();
        acceptConstraints.gridy = 5;
        acceptConstraints.insets = new Insets(10, 10, 10, 10);
        acceptConstraints.anchor = GridBagConstraints.CENTER;
        this.add(acceptButton, acceptConstraints);

        //RegistrationButton

        registrationButton.setActionCommand("change");
        registrationButton.addActionListener(actionListener);

        GridBagConstraints registrationConstraints = new GridBagConstraints();
        registrationConstraints.gridy = 5;
        registrationConstraints.gridx = 1;
        registrationConstraints.insets = new Insets(10, 10, 10, 10);
        registrationConstraints.anchor = GridBagConstraints.CENTER;
        this.add(registrationButton, registrationConstraints);
    }

    private void ChangeScreen() {
        if (!isAuthorization) {

            isAuthorization = true;

            //title

            title.setText("Authorization");

            //login title

            //loginField

            loginField.setText("");

            //passwordTitle

            //PasswordField

            passwordField.setText("");

            //emailTitle

            this.remove(emailTitle);

            //emailField

            this.remove(emailField);

            //AcceptButton

            this.remove(acceptButton);

            acceptButton.setActionCommand("authorizationAccept");

            GridBagConstraints acceptConstraints = new GridBagConstraints();
            acceptConstraints.gridy = 5;
            acceptConstraints.insets = new Insets(10, 10, 10, 10);
            acceptConstraints.anchor = GridBagConstraints.CENTER;
            this.add(acceptButton, acceptConstraints);

            //RegistrationButton

            this.remove(registrationButton);

            registrationButton.setText("Registration");

            GridBagConstraints registrationConstraints = new GridBagConstraints();
            registrationConstraints.gridy = 5;
            registrationConstraints.gridx = 1;
            registrationConstraints.insets = new Insets(10, 10, 10, 10);
            registrationConstraints.anchor = GridBagConstraints.CENTER;
            this.add(registrationButton, registrationConstraints);

            //Main

        } else {

            isAuthorization = false;

            //title

            title.setText("Registration");

            //login title

            //loginField

            loginField.setText("");

            //passwordTitle

            //PasswordField

            passwordField.setText("");

            //emailTitle

            GridBagConstraints emailTitleConstraints = new GridBagConstraints();
            emailTitleConstraints.gridy = 5;
            emailTitleConstraints.gridwidth = 2;
            emailTitleConstraints.anchor = GridBagConstraints.CENTER;
            emailTitleConstraints.insets = new Insets(10,10,10,10);
            this.add(emailTitle, emailTitleConstraints);


            //emailField

            GridBagConstraints emailConstraints = new GridBagConstraints();
            emailConstraints.gridy = 6;
            emailConstraints.gridwidth = 2;
            emailConstraints.anchor = GridBagConstraints.CENTER;
            emailConstraints.weightx = 0.5;
            emailConstraints.fill = GridBagConstraints.HORIZONTAL;
            emailConstraints.insets = new Insets(10,10,10,10);
            this.add(emailField, emailConstraints);

            //AcceptButton

            this.remove(acceptButton);

            acceptButton.setActionCommand("registrationAccept");

            GridBagConstraints acceptConstraints = new GridBagConstraints();
            acceptConstraints.gridy = 7;
            acceptConstraints.insets = new Insets(10, 10, 10, 10);
            acceptConstraints.anchor = GridBagConstraints.CENTER;
            this.add(acceptButton, acceptConstraints);


            //RegistrationButton

            this.remove(registrationButton);

            registrationButton.setText("Authorization");

            GridBagConstraints registrationConstraints = new GridBagConstraints();
            registrationConstraints.gridy = 7;
            registrationConstraints.gridx = 1;
            registrationConstraints.insets = new Insets(10, 10, 10, 10);
            registrationConstraints.anchor = GridBagConstraints.CENTER;
            this.add(registrationButton, registrationConstraints);

            //Main

        }
        this.revalidate();
        this.repaint();
    }

    public void registrationAccept(){

        if (loginField.getText() == null || passwordField.getText() == null) {

            JOptionPane.showMessageDialog(null, "Некорректные данные");

        } else {

            User user = new User();
            user.setLogin(loginField.getText());
            user.setPassword(passwordField.getText());

            UserService.set(user);
            JOptionPane.showMessageDialog(null, "Регистрация успешно завершена");

            int id = UserService.check(user.getLogin(), user.getPassword());
            authorizationAccept(id);


        }

    }

    public void authorizationAccept(int id){

        if(id != -1){
            CurrentUser.setId(id);
            System.out.println(CurrentUser.getId());
            this.dispose();
        }
        else{
            JOptionPane.showMessageDialog(null, "Пользователь не найден");
        }

    }
}
