package model;

import java.util.Objects;

public final class Song {

    private final String title;
    private final String artist;
    private final String album;
    private final String genre;
    private final PlayTime duration;
    private final String lyrics;

    public Song(String title, String artist, String album, String genre, PlayTime duration, String lyrics) {
        this.title = Objects.requireNonNull(title);
        this.artist = Objects.requireNonNull(artist);
        this.album = Objects.requireNonNull(album);
        this.genre = Objects.requireNonNull(genre);
        this.duration = Objects.requireNonNull(duration);
        this.lyrics = lyrics == null ? "" : lyrics;
    }

    public String getTitle() { return title; }
    public String getArtist() { return artist; }
    public String getAlbum() { return album; }
    public String getGenre() { return genre; }
    public PlayTime getDuration() { return duration; }
    public String getLyrics() { return lyrics; }

    public boolean hasLyrics() {
        return !lyrics.isBlank();
    }

    public boolean hasLyricsContaining(String phrase) {
        return lyrics.toLowerCase().contains(phrase.toLowerCase());
    }

    public boolean isLongerThan(PlayTime threshold) {
        return duration.isLongerThan(threshold);
    }

    public boolean matches(String query) {
        String needle = query.toLowerCase();
        return title.toLowerCase().contains(needle)
                || artist.toLowerCase().contains(needle)
                || album.toLowerCase().contains(needle);
    }

    public String describe() {
        return String.format("%s - %s (%s) [%s]", title, artist, album, duration);
    }

    @Override
    public String toString() { return describe(); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Song)) return false;
        Song that = (Song) o;
        return title.equals(that.title) && artist.equals(that.artist) && album.equals(that.album);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, artist, album);
    }
}
