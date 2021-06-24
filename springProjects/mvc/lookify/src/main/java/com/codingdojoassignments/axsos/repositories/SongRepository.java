package com.codingdojoassignments.axsos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojoassignments.axsos.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
	
	List<Song> findAll();
	
	List<Song> findByArtistContaining(String artist);
	
//	List<Song> finfTop10ByOrderByRatingDesc();
//	
//	List<Song> findSongByArtist(String artist);

}
