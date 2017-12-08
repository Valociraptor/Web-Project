package com.valociraptor.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.valociraptor.lookify.models.Song;
import com.valociraptor.lookify.services.SongService;

@Controller
public class Songs {
	
	private final SongService songService;
	public Songs(SongService songService) {
		this.songService = songService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/search/{search}") //g
	public String searchResults() {
		return "search.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model, @ModelAttribute("song") Song song) {
		List<Song> songs = songService.allSongs();
		model.addAttribute("songs", songs);
		return "list.jsp";
	}
	
	@RequestMapping("/search/topTen")
	public String topTen(Model model, @ModelAttribute("song") Song song) {
		List<Song> songs = songService.top();
		model.addAttribute("songs", songs);
		return "top.jsp";
	}
	
	@RequestMapping("/songs/{id}")
	public String songDetail(Model model, @PathVariable("id") Long id) {
		Song song = songService.getSong(id);
		if (song != null) {
			model.addAttribute("song", song);
			return "song.jsp";
		}
		else {
			return "redirect/dashboard.jsp";
		}
		
	}
	
	@RequestMapping("/songs/new")
	public String newSong() {
		return "addsong.jsp";
	}
	
	
	
	
	
	@PostMapping("/look")
	public String search(@RequestParam(value="search") String search, Model model, @ModelAttribute("song") Song song) {
		List<Song> songs = songService.searchSong(search);
		model.addAttribute ("songs", songs);
		return "redirect:search/{search}";
	}
	
	
	@PostMapping("/songs/add")
	public String addSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
        if (result.hasErrors()) {
            return "addsong.jsp";
        }
        else{
            songService.addSong(song);
            return "redirect:/dashboard";
        }
		
	}
	
	@RequestMapping("/songs/delete/{id}")
	public String deleteSong(@PathVariable("id") Long id) {
		songService.destroySong(id);
		return "redirect:/dashboard";
	}

}
