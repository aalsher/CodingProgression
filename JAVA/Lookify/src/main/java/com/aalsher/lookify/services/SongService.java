package com.aalsher.lookify.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.aalsher.lookify.models.Song;
import com.aalsher.lookify.repository.*;

@Service
public class SongService {
	private SongRepository songRepository;

	public SongService(SongRepository songRepository) {
		this.songRepository = songRepository;
	}
	
	private List<Song> songs = new ArrayList<Song>();

	public List<Song> getSongs() {
		return (List<Song>) songRepository.findAll();
	}

	public void addSong(Song song) {
		songRepository.save(song);
	}

	public Song findSongById(Long id) {
		return songRepository.findById(id);
	}

	public void deleteSong(Long id) {
		songRepository.delete(id);
	}
	
	public List<Song> searchByArtist(String searchQuery){
		return songRepository.findByArtistContaining(searchQuery);
	}
	
	public List<Song> findTopTen() {
		return (List<Song>) songRepository.findTop10ByOrderByRatingDesc();
	}

}
