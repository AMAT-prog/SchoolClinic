/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */

import java.time.*;

public class CalendarItem {
    public enum Kind { Note, Task, Event, Inventory }
    public enum Status { pending, done, cancelled }

    private Integer calendarId;
    private String title;
    private String description;
    private Kind kind = Kind.Note;
    private Status status = Status.pending;
    private LocalDate startDate;
    private LocalTime startTime; // null = all-day
    private boolean allDay = true;
    private LocalDateTime reminderAt;

    // --- Getters & Setters ---

    public Integer getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(Integer calendarId) {
        this.calendarId = calendarId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Kind getKind() {
        return kind;
    }

    public void setKind(Kind kind) {
        this.kind = (kind != null) ? kind : Kind.Note;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = (status != null) ? status : Status.pending;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    /** Getter for the stored all-day flag (not the computed convenience). */
    public boolean getAllDay() {
        return allDay;
    }

    public void setAllDay(boolean allDay) {
        this.allDay = allDay;
    }

    public LocalDateTime getReminderAt() {
        return reminderAt;
    }

    public void setReminderAt(LocalDateTime reminderAt) {
        this.reminderAt = reminderAt;
    }

    // Convenience: treat null startTime as all-day, even if allDay flag is false.
    public boolean isAllDay() {
        return allDay || startTime == null;
    }
}


