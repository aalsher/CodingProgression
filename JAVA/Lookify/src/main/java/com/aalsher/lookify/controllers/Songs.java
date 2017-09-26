package com.aalsher.lookify.controllers;

import java.util.ArrayList;
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

import com.aalsher.lookify.models.Song;
import com.aalsher.lookify.services.SongService;

@Controller
public class Songs {
	
	private final SongService songService;
	
	public Songs(SongService songService) {
		this.songService = songService;
	}
	
	@RequestMapping("/")
	public String index(@ModelAttribute("song") Song song, Model model) {
		System.out.println("Reached INdex");
		return "index.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(@ModelAttribute("song") Song song, Model model) {
		model.addAttribute("songs", songService.getSongs());
		return "dashboard.jsp";
	}

	
	@PostMapping("/search")
	public String search(@RequestParam(value="searchQuery") String searchQuery) {
		return "redirect:/search/{searchQuery}";
	}
	
	@RequestMapping("/search/{searchQuery}")
	public String searchDirect(@PathVariable String searchQuery, Model model) {
		model.addAttribute("searchedArtist", songService.searchByArtist(searchQuery));
		return "search.jsp";
	}
	
	@RequestMapping("/topten")
	public String topTenSongs(Model model) {
		List<Song> topten = songService.findTopTen();
		model.addAttribute("topten",topten);
		System.out.println(topten);
		return "topten.jsp";
	}

	@RequestMapping("/songs/new")
	public String addSong(@ModelAttribute("song") Song song, BindingResult result, Model model) {
		return "addsong.jsp";
	}
	
	@PostMapping("/songs/new")
	public String createSongs(@Valid @ModelAttribute("song") Song song, BindingResult result, Model model) {
        if (result.hasErrors()) {
    		return "addsong.jsp";
        }else{
        	songService.addSong(song);
    			return "redirect:/dashboard";
        }
	}

	@RequestMapping("/songs/{id}")
	public String findSongById(Model model, @PathVariable("id") Long id) {
		model.addAttribute("song", songService.findSongById(id));
		return "viewsong.jsp";
	}


	@PostMapping("/songs/delete/{id}")
	public String deleteSong(@PathVariable("id") Long id) {
	    	songService.deleteSong(id);
	        return "redirect:/dashboard";
	}

}
