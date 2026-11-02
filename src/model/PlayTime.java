package model;

import java.util.Objects;

public final class PlayTime implements Comparable<PlayTime> {

    private final int totalSeconds;

    private PlayTime(int totalSeconds) {
        if (totalSeconds < 0) {
            throw new IllegalArgumentException("Duration cannot be negative");
        }
        this.totalSeconds = totalSeconds;
    }

    public static PlayTime ofMinutesSeconds(String mmss) {
        String[] parts = mmss.trim().split(":");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Expected mm:ss, got: " + mmss);
        }
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);
        return new PlayTime(minutes * 60 + seconds);
    }

    public static PlayTime ofSeconds(int seconds) {
        return new PlayTime(seconds);
    }

    public int totalSeconds() { return totalSeconds; }

    public PlayTime plus(PlayTime other) {
        return new PlayTime(this.totalSeconds + other.totalSeconds);
    }

    public boolean isLongerThan(PlayTime other) {
        return this.totalSeconds > other.totalSeconds;
    }

    @Override
    public int compareTo(PlayTime other) {
        return Integer.compare(this.totalSeconds, other.totalSeconds);
    }

    @Override
    public String toString() {
        return String.format("%d:%02d", totalSeconds / 60, totalSeconds % 60);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlayTime)) return false;
        return this.totalSeconds == ((PlayTime) o).totalSeconds;
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalSeconds);
    }
}
