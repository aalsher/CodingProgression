package com.aalsher.lookify.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aalsher.lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long>{
	Song findById(Long id);
	List<Song> findByArtistContaining(String searchQuery);
	List<Song> findTop10ByOrderByRatingDesc();
}
