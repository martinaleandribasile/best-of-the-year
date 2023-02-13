package com.example.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring.model.Movie;
import com.example.spring.model.Song;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/")
public class mainController {

	@GetMapping()
	public String home(Model model) {  
		String name = "Martina";
		model.addAttribute("name", name);
		return "index"; // nome file che voglio restituire
	}
	
	private List<Movie> getBestMovie(){
		List<Movie> moviesList = new ArrayList<>(); 
		Movie movie1= new Movie(1, "il Ciclone");
		Movie movie2= new Movie(2, "Die Hard");
		Movie movie3= new Movie(3, "Kill Bill vol1");
		Movie movie4= new Movie(4, "Kill Bill vol2");
		Movie movie5= new Movie(5, "Il Padrino");
		moviesList.add(movie1);
		moviesList.add(movie2);
		moviesList.add(movie3);
		moviesList.add(movie4);
		moviesList.add(movie5);
		return moviesList;
		
	}
	@GetMapping("/movies")
	public String showMovies(Model model) {
		List<Movie> movies= getBestMovie();
		model.addAttribute("films" , movies);
		return "movies";
	}
	
	private List<Song> getBestSong(){
		List<Song> songsList = new ArrayList<>(); 
		Song song1= new Song(1, "Canzone1");
		Song song2= new Song(2, "Canzone2");
		songsList.add(song1);
		songsList.add(song2);
		return songsList;
	}
	
	@GetMapping("/songs")
	public String showSong(Model model) {
		List<Song> songs= getBestSong();
		model.addAttribute("canzoni" , songs);
		return "songs";
	}
	
	@GetMapping("/songs/{id}") 	
	public String dettaglioCanzone(Model model, @PathVariable("id") String id ) {
		int idSong= Integer.parseInt(id)-1;
		model.addAttribute("song", getBestSong().get(idSong));
		return "canzone";
	}
	
	@GetMapping("/movies/{id}") 	
	public String dettaglioFilm(Model model, @PathVariable("id") String id ) {
		int idFilm= Integer.parseInt(id)-1;
		model.addAttribute("film", getBestMovie().get(idFilm));
		return "film";
	}
	
}
