package com.codingdojoassignments.axsos.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojoassignments.axsos.models.Song;
import com.codingdojoassignments.axsos.services.SongService;

@Controller
public class SongController {
	
private final SongService songService;
	
	public SongController(SongService songService) {
		this.songService = songService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "home.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		model.addAttribute("allSongs", this.songService.getAllSongs());		
		return "lookify.jsp";
	}
	
	@RequestMapping("/songs/new")
	public String addSong (@ModelAttribute("song") Song song) {
		return "create.jsp";
	}
	
	@RequestMapping(value = "/songs/create", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("song") Song song,
			BindingResult result) {
		
		if (result.hasErrors()) {
			return "create.jsp";
		} else {
			this.songService.createSong(song);
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping("/search")
	public String searchSubmit(@RequestParam("artist") String artist) {
		return ("redirect:/search/" + artist);
	}
	
	@RequestMapping("/search/{artist}")
	public String searchedArtist(Model viewModel, @PathVariable("artist") String artist) {
		viewModel.addAttribute("allSongs", this.songService.findSongByArtist(artist));
		return "search.jsp";
	}
	
	@RequestMapping(value = "/songs/{id}")
	public String show(@PathVariable("id") Long id, Model viewModel) {
		Song sSong = this.songService.getById(id);
		viewModel.addAttribute("sSong", sSong);
		return "show.jsp";
	}
	
	@RequestMapping(value = "/songs/{id}/delete")
	public String delete(@PathVariable("id") Long id) {
		this.delete(id);
		return "redirect:/lookify";
	}
	

}
