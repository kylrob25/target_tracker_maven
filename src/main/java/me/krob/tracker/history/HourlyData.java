package me.krob.tracker.history;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class HourlyData {
    private int id;
    private int historyId;

    private String jobName; // e.g: cutting, marking, auditing

    private int hour;
    private int amount;
}
