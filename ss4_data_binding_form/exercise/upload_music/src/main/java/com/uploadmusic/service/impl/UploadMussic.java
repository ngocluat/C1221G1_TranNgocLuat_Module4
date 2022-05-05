package com.uploadmusic.service.impl;

import com.uploadmusic.model.Music;
import com.uploadmusic.repository.IUPdateRepposoitory;
import com.uploadmusic.service.IUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UploadMussic implements IUpload {
    @Autowired
    IUPdateRepposoitory iuPdateRepposoitory;


    private static List<Music> musicList;


    @Override
    public List<Music> findAll() {
        return iuPdateRepposoitory.findAll();
    }

    @Override
    public void save(Music music) {
        iuPdateRepposoitory.save(music);
    }
}
