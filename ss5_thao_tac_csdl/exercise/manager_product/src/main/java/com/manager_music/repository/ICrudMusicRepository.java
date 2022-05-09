package com.manager_music.repository;

import com.manager_music.model.Music;

import java.util.List;

public interface ICrudMusicRepository {


    List<Music> findAll();

    Music findOne(Long id);

    void save(Music Music);

    void delete(Music music);


    void update( Music music);

}
