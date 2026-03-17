import javax.swing.*;
import java.awt.*;

public class PreviewPanel extends JPanel {

    private JLabel firstNameLabel = new JLabel();
    private JLabel lastNameLabel = new JLabel();
    private JLabel emailLabel = new JLabel();

    public PreviewPanel(MainFrame parent) {

        setLayout(new GridLayout(4, 2, 5, 5));

        add(firstNameLabel);
        add(lastNameLabel);
        add(emailLabel);

        JButton backButton = new JButton("Powrót do edycji");
        add(backButton);

        backButton.addActionListener(e -> parent.showForm());
    }

    public void loadData() {
        UserProfile profile = StorageManager.load();

        if (profile != null) {
            firstNameLabel.setText("Imię: " + profile.getFirstName());
            lastNameLabel.setText("Nazwisko: " + profile.getLastName());
            emailLabel.setText("Email: " + profile.getEmail());
        } else {
            firstNameLabel.setText("Brak danych");
            lastNameLabel.setText("");
            emailLabel.setText("");
        }
    }
}