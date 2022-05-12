package com.music.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class MusicDto {

    private static final String NAMEVALID = "^[\\p{Lu}\\p{Ll}\\s]{5,50}$";

    private Long id;

    @Pattern(regexp = "^[a-zA-Z0-9\\+]*$", message = "Name cannot have special characters ")
    @NotEmpty(message = "Song title can't be blank")
    @Size(max = 800, message = " Song title should not exceed 800 characters")
    private String nameMusic;

    @NotEmpty(message = "name title can't be blank")
    @Size(max = 800, message = " name title should not exceed 300 characters")
    @Pattern(regexp = NAMEVALID, message = "Name cannot have special characters ")
    private String artist;


    @NotEmpty(message = "name title can't be blank")
    @Length( max = 1000, message = "category cannot ")
    @Pattern(regexp = NAMEVALID, message = "Name cannot have special characters ")
    private String category;


    private String pathFileMusic;


    public MusicDto() {
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

}
