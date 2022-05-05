package com.uploadmusic.repository;

import com.uploadmusic.model.Music;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UpdateRepository implements IUPdateRepposoitory {
    static List<Music> musicList = new ArrayList<>();

    static {
        musicList.add(new Music("Quê Hương ", "Tran Luat ", "Rap", "D//abc//music"));
        musicList.add(new Music("Canh Dong", "Tran  ", "Rap", "D//abc//music"));
        musicList.add(new Music("Gia Nhu", "Tran Luat ", "Rap", "D//abc//music"));
        musicList.add(new Music("there is not at all ", "Tran Luat ", "Rap", "D//abc//music"));
    }

    @Override
    public List<Music> findAll() {
        return musicList;
    }

    @Override
    public void save(Music music) {
        musicList.add(music);
    }
}
