package com.music.service.impl;


import com.music.model.Music;
import com.music.repository.ICrudMusicRepository;
import com.music.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService {
    @Autowired
    private ICrudMusicRepository iCrudMusicRepository;


    @Override
    public List<Music> findAll() {
        return iCrudMusicRepository.findAll();
    }

    @Override
    public Music findOne(Long id) {
        return iCrudMusicRepository.findById(id).get();
    }

    @Override
    public void save(Music music) {
        iCrudMusicRepository.save(music);
    }

    @Override
    public void delete(Music music) {
        iCrudMusicRepository.delete(music);
    }

    @Override
    public void update(Music music) {
        iCrudMusicRepository.save(music);
    }
}
