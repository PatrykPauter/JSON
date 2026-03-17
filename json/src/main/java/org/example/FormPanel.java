import javax.swing.*;
import java.awt.*;

public class FormPanel extends JPanel {

    private JTextField firstNameField = new JTextField(15);
    private JTextField lastNameField = new JTextField(15);
    private JTextField emailField = new JTextField(15);

    public FormPanel(MainFrame parent) {

        setLayout(new GridLayout(4, 1, 5, 5));

        add(new JLabel("Imię:"));
        add(firstNameField);

        add(new JLabel("Nazwisko:"));
        add(lastNameField);

        add(new JLabel("Email:"));
        add(emailField);

        JButton saveButton = new JButton("Zapisz i Dalej");
        add(new JLabel());
        add(saveButton);

        saveButton.addActionListener(e -> {

            UserProfile profile = new UserProfile(
                    firstNameField.getText(),
                    lastNameField.getText(),
                    emailField.getText()
            );

            StorageManager.save(profile);

            parent.showPreview();
        });
    }
}