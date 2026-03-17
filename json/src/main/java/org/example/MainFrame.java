import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private CardLayout cardLayout = new CardLayout();
    private JPanel mainPanel = new JPanel(cardLayout);

    private FormPanel formPanel;
    private PreviewPanel previewPanel;

    public MainFrame() {

        setTitle("User Profile App");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        formPanel = new FormPanel(this);
        previewPanel = new PreviewPanel(this);

        mainPanel.add(formPanel, "FORM");
        mainPanel.add(previewPanel, "PREVIEW");

        add(mainPanel);
        setVisible(true);
    }

    public void showPreview() {
        previewPanel.loadData();
        cardLayout.show(mainPanel, "PREVIEW");
    }

    public void showForm() {
        cardLayout.show(mainPanel, "FORM");
    }
}