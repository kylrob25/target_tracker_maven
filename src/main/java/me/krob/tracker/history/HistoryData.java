package me.krob.tracker.history;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.Map;

@RequiredArgsConstructor @Getter @Setter
public class HistoryData {
    private int id;

    private int userId;

    // Could store Enum ordinals instead
    private String processName; // e.g: cutting, marking, auditing
    private String processType; // e.g: leather, paper, wood

    private Date date;

    private int amount;
    private Map<Integer, HourlyData> hourlyDataMap;
}
