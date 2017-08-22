package training.egen.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import training.egen.rest.entity.Title;
import training.egen.rest.service.TitleService;

@RestController 
@RequestMapping(path="{id1}")
public class TitleController {
	@Autowired
	TitleService service;
	@RequestMapping(method=RequestMethod.GET,path="Title/All", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Title> findAll(@PathVariable("id1") String userName)
	{
		return service.findAll(userName);
	}
	
	
	@RequestMapping(method=RequestMethod.GET,path="TitleSearch/{id2}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Title> freeSearch(@PathVariable("id2") String searchVar, @PathVariable("id1") String userName)
	{
		return service.freeSearch(searchVar,userName);
	}
	
	
	@RequestMapping(method=RequestMethod.GET, path="Title/Year/{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Title> findByYear(@PathVariable("id") String year,@PathVariable("id1") String userName)
	{
		return service.findByYear(year,userName);
	}
	
	@RequestMapping(method=RequestMethod.GET, path="Title/Type/{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Title> findByType(@PathVariable("id") String type,@PathVariable("id1") String userName)
	{
		return service.findByType(type,userName);
	}
	
	@RequestMapping(method=RequestMethod.GET, path="Title/Genre/{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Title> findByGenre(@PathVariable("id") String genre,@PathVariable("id1") String userName)
	{
		return service.findByGenre(genre,userName);
	}
	
	@RequestMapping(method=RequestMethod.GET, path="Title/SortByRatings", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Title> sortByRatings(@PathVariable("id1") String userName)
	{
		return service.sortByRatings(userName);
	}
	@RequestMapping(method=RequestMethod.GET, path="Title/SortByYear", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Title> sortByYear(@PathVariable("id1") String userName)
	{
		return service.sortByYear(userName);
	}
	
	@RequestMapping(method=RequestMethod.GET, path="Title/SortByGenre", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Title> sortByGenre(@PathVariable("id1") String userName)
	{
		return service.sortByGenre(userName);
	}
	
	@RequestMapping(method=RequestMethod.GET, path="TopMovies", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Title> topRatedMovies(@PathVariable("id1") String userName)
	{
		return service.topRated("movies",userName);
	}
	
	
	@RequestMapping(method=RequestMethod.GET, path="TopTVSeries", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Title> topRatedTVseries(@PathVariable("id1") String userName)
	{
		return service.topRated("tvseries",userName);

	}
	
	
	@RequestMapping(method=RequestMethod.GET, path="Title/{id}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Title findOne(@PathVariable("id") String titleId,@PathVariable("id1") String userName)
	{
		return service.findOne(titleId,userName);
	}
	
	@RequestMapping(method=RequestMethod.POST, path="Title",produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Title create(@RequestBody Title title,@PathVariable("id1") String adminName)
	{
		return service.create(title,adminName);
	}
	@RequestMapping(method=RequestMethod.PUT, path="Title/{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Title update(@PathVariable("id") String titleId,@RequestBody Title mov,@PathVariable("id1") String adminName)
	{
		return service.update(titleId,mov,adminName);
	}
	@RequestMapping(method=RequestMethod.DELETE, path="Title/{id}")
	public void delete(@PathVariable("id") String titleId,@PathVariable("id1") String adminName)
	{
		service.delete(titleId,adminName);
	}

}
