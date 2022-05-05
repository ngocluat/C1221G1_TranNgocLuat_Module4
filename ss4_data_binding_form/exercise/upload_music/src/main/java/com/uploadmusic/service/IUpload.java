package com.uploadmusic.service;

import com.uploadmusic.model.Music;

import java.util.List;

public interface IUpload {

    List<Music> findAll() ;

    void save(Music music);


}
