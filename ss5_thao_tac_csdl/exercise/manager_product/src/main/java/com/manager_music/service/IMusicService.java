package com.manager_music.service;

import com.manager_music.model.Music;

import java.util.List;

public interface IMusicService {

    List<Music> findAll();

    Music findOne(Long id);

    void save(Music Music);

    void delete(Music music);


    void update( Music music);


}
