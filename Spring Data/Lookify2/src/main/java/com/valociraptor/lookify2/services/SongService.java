package com.valociraptor.lookify2.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.valociraptor.lookify2.models.Song;
import com.valociraptor.lookify2.repositories.SongRepository;

@Service
public class SongService {
	
	private final SongRepository songRepository;
	
	
    public SongService(SongRepository SongRepository){
        this.songRepository = SongRepository;
    }
	
	public void addSong(Song song) {
		songRepository.save(song);
		
	}
	
	public void destroySong(Long id) {
		songRepository.delete(id);
	}
	
	public Song getSong(Long id) {
		return songRepository.findOne(id);
		
	}
	
	public List<Song> findByArtistContaining(String search) {
		return songRepository.findByArtistContaining(search);
	}
	
	public List<Song> findAll(){
		return songRepository.findAll();
		
	}
	
	public List<Song> top(){
		return songRepository.findTop10ByOrderByRatingDesc();
	}
	
	

}
