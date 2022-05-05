package com.uploadmusic.repository;

import com.uploadmusic.model.Music;

import java.util.List;

public interface IUPdateRepposoitory {

    List<Music> findAll() ;

    void save(Music music);
}
