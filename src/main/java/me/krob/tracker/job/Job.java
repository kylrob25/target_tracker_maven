package me.krob.tracker.job;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class Job {
    private final int id;
    private String name;
    private int target;
}
