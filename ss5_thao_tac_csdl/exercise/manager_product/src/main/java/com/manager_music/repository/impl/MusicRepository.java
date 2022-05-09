package com.manager_music.repository.impl;

import com.manager_music.model.Music;
import com.manager_music.repository.BaseRepository;
import com.manager_music.repository.ICrudMusicRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class MusicRepository implements ICrudMusicRepository {


    @Override
    public List<Music> findAll() {
        TypedQuery<Music> musicTypedQuery = BaseRepository.
                entityManager.createQuery("select  m  from Music m", Music.class);
        return musicTypedQuery.getResultList();
    }

    @Override
    public Music findOne(Long id) {
        return BaseRepository.entityManager.find(Music.class, id);
    }

    @Override
    public void save(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(music);
        entityTransaction.commit();
    }

    @Override
    public void delete(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();

        entityTransaction.begin();
        BaseRepository.entityManager.remove(music);
        entityTransaction.commit();
    }

    @Override
    public void update(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(music);
        entityTransaction.commit();
    }
}
