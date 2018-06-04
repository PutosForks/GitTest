package org.stringdata.entity;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

import static java.lang.Math.round;

public class TimeTrack implements Comparable<TimeTrack> {

    public TimeTrack(String projectName, String issueName, String userlogin, Long duration, LocalDate date, String description) {
        this.projectName = projectName;
        this.issueName = issueName;
        this.userlogin = userlogin;
        this.duration = duration;
        this.date = date;
        this.description = description;
    }

    String projectName;

    String issueName;

    String userlogin;

    Long duration;

    LocalDate date;

    String description;

    public String getProjectName() {
        return projectName;
    }

    public String getIssueName() {
        return issueName;
    }

    public String getUserlogin() {
        return userlogin;
    }

    public Long getDuration() {
        return duration;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }


    public int getMonthDate() {
        return date.getMonthValue();
    }

    public Double getDurationByHour() {
        return (double) (duration / 60);


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimeTrack)) return false;
        TimeTrack timeTrack = (TimeTrack) o;
        return Objects.equals(projectName, timeTrack.projectName) &&
                Objects.equals(issueName, timeTrack.issueName) &&
                Objects.equals(userlogin, timeTrack.userlogin) &&
                Objects.equals(duration, timeTrack.duration) &&
                Objects.equals(date, timeTrack.date) &&
                Objects.equals(description, timeTrack.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(projectName, issueName, userlogin, duration, date, description);
    }

    @Override
    public String toString() {
        return "TimeTrack{" +
                "projectName='" + projectName + '\'' +
                ", issueName='" + issueName + '\'' +
                ", userlogin='" + userlogin + '\'' +
                ", duration=" + duration +
                ", date=" + date +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public int compareTo(TimeTrack o) {
        return getDate().compareTo(o.getDate());
    }
}
