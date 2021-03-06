package com.nus.duke.data;

import java.time.LocalDateTime;

import com.nus.duke.parser.DateParser;

/**
 * Deadline is a type of Task that needs to be done before a specific date/time.
 */
public class Deadline extends Task {

    /**
     * Indicates the end date/time of the deadline.
     */
    protected final LocalDateTime by;

    public Deadline(String description, LocalDateTime by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + DateParser.DEFAULT_OUTPUT_FORMATTER
                .format(this.by) + ")";
    }
}
