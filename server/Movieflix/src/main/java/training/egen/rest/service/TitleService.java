package training.egen.rest.service;

import java.util.List;


import training.egen.rest.entity.Title;


public interface TitleService {
	public List<Title> findAll(String userName);
	public List<Title> findByYear(String year,String userName);
	public List<Title> findByType(String type,String userName);
	public List<Title> findByGenre(String genre,String userName);
	public Title findOne(String titleId,String userName);
	public int findavgratings(String titleId,String userName);
	public List<Title> sortByRatings(String userName);
	public List<Title> sortByYear(String userName);
	public List<Title> sortByGenre(String userName);
	public Title create(Title mov,String adminName);
	public Title update(String titleId, Title mov,String adminName);
	public void delete(String titleId,String adminName);
	public List<Title> freeSearch(String searchVar, String userName);
	public List<Title> topRated(String movietv,String userName);
}
