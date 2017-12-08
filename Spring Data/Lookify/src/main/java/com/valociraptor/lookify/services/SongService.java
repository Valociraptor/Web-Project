package com.valociraptor.lookify.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.valociraptor.lookify.models.Song;
import com.valociraptor.lookify.repositories.SongRepository;

@Service
public class SongService {
	
	private SongRepository songRepository;
	
	
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
	
	public List<Song> searchSong(String search) {
		return songRepository.findByArtistContaining(search);
	}
	
	public List<Song> allSongs(){
		return songRepository.findAll();
		
	}
	
	public List<Song> top(){
		return songRepository.findTop10OrderByRatingDesc();
	}
	
	

}
