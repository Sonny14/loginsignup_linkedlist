package LoginPortal;

import static LoginPortal.SignUp.list;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

    JLabel titleLabel, idLabel, passLabel;
    JTextField idField; // ID field
    JPasswordField passField; // Password field
    JButton loginBtn, clearBtn; // Login and clear buttons
    JPanel panel; // Panel

    // Constructor
    Login() {
        // Panels
        panel = new JPanel();
        panel.setSize(510, 780);
        panel.setLayout(null);

        // Labels
        titleLabel = new JLabel("Login to Cinetix");
        titleLabel.setFont(new Font("Sans Serif", Font.BOLD, 24));
        idLabel = new JLabel("Employee ID:");
        idLabel.setFont(new Font("Sans Serif", Font.PLAIN, 14));
        passLabel = new JLabel("Password:");
        passLabel.setFont(new Font("Sans Serif", Font.PLAIN, 14));
        add(titleLabel);
        add(idLabel);
        add(passLabel);
        titleLabel.setBounds(160, 50, 200, 30);
        idLabel.setBounds(50, 150, 100, 20);
        passLabel.setBounds(50, 230, 100, 20);

        // Text Fields
        idField = new JTextField();
        passField = new JPasswordField();
        add(idField);
        add(passField);
        idField.setBounds(160, 150, 250, 35);
        passField.setBounds(160, 230, 250, 35);

        // Buttons
        loginBtn = new JButton("Login");
        clearBtn = new JButton("Signup");
        loginBtn.addActionListener(this);
        clearBtn.addActionListener(this);
        add(loginBtn);
        add(clearBtn);
        loginBtn.setBounds(275, 310, 130, 35);
        clearBtn.setBounds(130, 310, 130, 35);
        add(panel);

        //Frame Properties
        this.setTitle("Login");
        this.setSize(520, 520);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    // Action performed
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == loginBtn) {
                String s1 = idField.getText();
                char[] p = passField.getPassword();
                int employeeId = Integer.parseInt(s1);
                String pass = new String(p);

                try {
                    //Login logic here
                    if (list.validateUser(employeeId, pass)) {
                        JOptionPane.showMessageDialog(null, "Successfully logged in", "Message", JOptionPane.PLAIN_MESSAGE);
                    }

                } catch (Exception ex) {
                    System.out.println(ex);
                }
            } else {
                  
                  //DUMMY JUST TO TEST RELOGIN FUNCTION
                  new SignUp();
                  
//                idField.setText("");
//                passField.setText("");
                  
    
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void main(String arr[]) {
        new Login();
    }
}
