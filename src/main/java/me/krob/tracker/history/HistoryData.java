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

    private Date date;

    private int amount;
    private Map<Integer, HourlyData> hourlyDataMap;

    public void createHourlyData(int hour, int amount, String jobName) {
        hourlyDataMap.computeIfAbsent(hour, h -> {
           HourlyData hourlyData = new HourlyData();
           hourlyData.setHistoryId(id);
           hourlyData.setHour(h);
           hourlyData.setAmount(amount);
           hourlyData.setJobName(jobName);
           return hourlyData;
        });
    }

    public boolean contains(int hour) {
        return hourlyDataMap.containsKey(hour);
    }
}
