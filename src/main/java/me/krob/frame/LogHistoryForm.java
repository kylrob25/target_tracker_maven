package me.krob.frame;

import javax.swing.*;
import java.awt.*;

public class LogHistoryForm extends JFrame {
    private JPanel mainPanel;
    private JTextField textField1;
    private JButton setButton;
    private JTable dataTable;
    private JButton insertButton;
    private JButton deleteButton;
    private JComboBox hourBox;
    private JSpinner amountSpinner;
    private JTextField typeField;
    private JButton addButton;

    public LogHistoryForm() {
        super("Log History");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 700));
        pack();

        setContentPane(mainPanel);
    }
}
