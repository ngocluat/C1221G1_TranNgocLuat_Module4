package com.uploadmusic.model;

public class Music {
    String nameMusic;
    String artist;
    String Category;
    String pathFileMusic;

    public Music(String nameMusic, String artist, String category, String pathFileMusic) {
        this.nameMusic = nameMusic;
        this.artist = artist;
        Category = category;
        this.pathFileMusic = pathFileMusic;
    }

    public Music() {
    }

    public String getNameMusic() {
        return nameMusic;
    }

    public void setNameMusic(String nameMusic) {
        this.nameMusic = nameMusic;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getPathFileMusic() {
        return pathFileMusic;
    }

    public void setPathFileMusic(String pathFileMusic) {
        this.pathFileMusic = pathFileMusic;
    }

    @Override
    public String toString() {
        return "Music{" +
                "nameMusic='" + nameMusic + '\'' +
                ", artist='" + artist + '\'' +
                ", Category='" + Category + '\'' +
                ", pathFileMusic='" + pathFileMusic + '\'' +
                '}';
    }
}
