package com.music.repository;


import com.music.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ICrudMusicRepository extends JpaRepository<Music, Long> {


}
