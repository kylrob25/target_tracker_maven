package me.krob.frame;

import com.google.common.collect.Lists;
import me.krob.tracker.Tracker;
import me.krob.tracker.history.HistoryData;
import me.krob.tracker.history.HourlyData;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class LogHistoryForm extends JFrame {
    private final Tracker tracker;

    private JPanel mainPanel;
    private JTextField pinField;
    private JButton setPinButton;
    private JTable dataTable;
    private JButton insertButton;
    private JButton deleteButton;
    private JComboBox<Integer> hourBox;
    private JSpinner amountSpinner;
    private JButton addButton;
    private JComboBox<String> jobBox;

    private int currentUserId;
    private HistoryData currentHistoryData;
    private List<HistoryData> historyDataList = Lists.newArrayList();

    public LogHistoryForm(Tracker tracker) {
        super("Log History");
        this.tracker = tracker;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 700));
        pack();

        setContentPane(mainPanel);

        loadHourBox();
        loadTypeBox();

        addButtonListeners();
    }

    private void loadTypeBox() {
        tracker.getDatabaseManager().getJobDAO().getAll().forEach(job -> {
            String name = job.getName();
            jobBox.addItem(name);
        });
    }

    private void loadHourBox() {
        for (int i = 1; i < 9; i++) {
            hourBox.addItem(i);
        }
    }

    private void addButtonListeners() {
        setPinButton.addActionListener(l -> {
            try {
                String text = pinField.getText();
                if (text.length() > 4) {
                    throw new Throwable("'pinField' text too long.");
                }

                int userid = Integer.parseInt(text);
                // TODO: Check for user using the pin
            } catch (Throwable throwable) {
                pinField.setText(null);
                System.out.println("[Error] " + throwable.getMessage());
            }
        });

        addButton.addActionListener(l -> {
            try {
                int hour = hourBox.getItemAt(hourBox.getSelectedIndex());
                int amount = (int) amountSpinner.getValue();
                String jobName = jobBox.getItemAt(jobBox.getSelectedIndex());

                HistoryData historyData = getCurrentHistoryData();

                if (historyData.contains(hour)) {
                    throw new Throwable(String.format("Data for hour %s already exists.", hour));
                }

                historyData.createHourlyData(hour, amount, jobName);
            } catch (Throwable throwable) {
                System.out.println("[Error] " + throwable.getMessage());
            }

            hourBox.setSelectedIndex(0);
            jobBox.setSelectedIndex(0);
            amountSpinner.setValue(0);
        });
    }

    private HistoryData getCurrentHistoryData() {
        if (currentHistoryData == null) {
            currentHistoryData = new HistoryData();
            currentHistoryData.setUserId(currentUserId);
        }
        return currentHistoryData;
    }
}
