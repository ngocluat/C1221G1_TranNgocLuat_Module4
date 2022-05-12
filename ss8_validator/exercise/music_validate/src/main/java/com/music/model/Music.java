package com.music.model;

import javax.persistence.*;

@Entity
@Table(name = "music")
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameMusic;
    private String artist;
    private String category;
    private String pathFileMusic;

    public Music(String nameMusic, String artist, String category, String pathFileMusic) {
        this.nameMusic = nameMusic;
        this.artist = artist;
        this.category = category;
        this.pathFileMusic = pathFileMusic;
    }

    public Music(Long id, String nameMusic, String artist, String category, String pathFileMusic) {
        this.id = id;
        this.nameMusic = nameMusic;
        this.artist = artist;
        this.category = category;
        this.pathFileMusic = pathFileMusic;
    }

    public Music() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
                ", Category='" + category + '\'' +
                ", pathFileMusic='" + pathFileMusic + '\'' +
                '}';
    }
}
