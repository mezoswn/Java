package com.codingdojoassignments.axsos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojoassignments.axsos.models.Song;
import com.codingdojoassignments.axsos.repositories.SongRepository;

@Service
public class SongService {

private final SongRepository songRepository;
	
	public SongService(SongRepository songRepository) {
		this.songRepository = songRepository;
	}
	
	public List<Song> getAllSongs() {
		return this.songRepository.findAll();
	}
	
	public List<Song> findSongByArtist(String artist) {
		return this.songRepository.findByArtistContaining(artist);
	}
	
	public Song createSong(Song song) {
		return this.songRepository.save(song);
	}
	
	public Song getById(Long id) {
		Optional<Song> optionalSong = this.songRepository.findById(id);
		if (optionalSong.isPresent()) {
			return optionalSong.get();
		}
		return null;
	}
	
	public void delete(Long id) {
		this.songRepository.deleteById(id);
	}
	
}
