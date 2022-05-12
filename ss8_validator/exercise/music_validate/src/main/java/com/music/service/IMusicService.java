package com.music.service;

import com.music.model.Music;

import java.util.List;

public interface IMusicService {

    List<Music> findAll();

    Music findOne(Long id);

    void save(Music Music);

    void delete(Music music);


    void update( Music music);


}
