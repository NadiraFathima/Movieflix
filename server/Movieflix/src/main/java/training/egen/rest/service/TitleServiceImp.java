package training.egen.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import training.egen.rest.entity.Title;
import training.egen.rest.entity.Users;
import training.egen.rest.exception.NotFoundException;
import training.egen.rest.repository.TitleRepository;
import training.egen.rest.repository.UsersRepository;

@Service
public class TitleServiceImp implements TitleService{

	@Autowired
	TitleRepository repository;
	
	@Autowired
	UsersRepository urepository;
	
	public Users adminPrivilegeCheck(String adminName)
	{
		Users existing=findByNameCheck(adminName);
		if(!(existing.getPrivilege()).equalsIgnoreCase("Admin"))	
			throw new RuntimeException("This user doesnot have admin privileges.");
		return existing;	
	}
	
	public Users findByNameCheck(String userName)
	{
		Users existing=urepository.findByName(userName);
		if(existing==null)
		{
			throw new NotFoundException("This user is not registered to Movieflix :" + userName);
		}
		return existing;
	}
	
	@Override
	public List<Title> findAll(String userName) {
		findByNameCheck(userName);
		return repository.findAll();
	}

	@Override
	public Title findOne(String titleId,String userName) {
		findByNameCheck(userName);
		Title existing=repository.findOne(titleId);
		if(existing==null)
		{
			throw new NotFoundException("Title with id:" + titleId + "not found");
		}
		return existing;
	}

	@Override
	@Transactional
	public Title create(Title mov,String adminName) {
		adminPrivilegeCheck(adminName);
		return repository.create(mov);
	}

	@Override
	@Transactional
	public Title update(String titleId, Title mov,String adminName) {
		
		adminPrivilegeCheck(adminName);
		
		Title existing=repository.findOne(titleId);
		if(existing==null)
		{
			throw new NotFoundException("Title with id: " + titleId + " not found");
		}
		return repository.update(mov);
	}

	@Override
	@Transactional
	public void delete(String titleId,String adminName) {
		
		adminPrivilegeCheck(adminName);		
		Title existing=repository.findOne(titleId);
		if(existing==null)
		{
			throw new NotFoundException("Title with id: " + titleId + " not found");
		}
		repository.delete(existing);
	}

	@Override
	public List<Title> findByYear(String year,String userName) {
		findByNameCheck(userName);
		List<Title> existing=repository.findByYear(year);
		if(existing==null)
		{
			throw new NotFoundException("There are no titles found in the year " + year);
		}
		return existing;
	}

	@Override
	public List<Title> findByType(String type,String userName) {
		findByNameCheck(userName);
		List<Title> existing=repository.findByType(type);
		if(existing==null)
		{
			throw new NotFoundException("There are no titles found ofthis type " + type);
		}
		return existing;
	}

	@Override
	public List<Title> findByGenre(String genre,String userName) {
		findByNameCheck(userName);
		List<Title> existing=repository.findByGenre(genre);
		if(existing==null)
		{
			throw new NotFoundException("There are no titles found in the " + genre + "genre.");
		}
		return existing;
	}

	@Override
	public List<Title> sortByRatings(String userName) {
		findByNameCheck(userName);
		return repository.sortByRatings();
	}

	@Override
	public List<Title> sortByYear(String userName) {
		findByNameCheck(userName);
		return repository.sortByYear();
	}

	@Override
	public List<Title> sortByGenre(String userName) {
		findByNameCheck(userName);
		return repository.sortByGenre();
	}

	@Override
	public int findavgratings(String titleId,String userName) {
		findByNameCheck(userName);
		return repository.findavgratings(titleId);
		
	}

	@Override
	public List<Title> freeSearch(String searchVar,String userName) {
		findByNameCheck(userName);
		return repository.freeSearch(searchVar);
	}

	@Override
	public List<Title> topRated(String movietv, String userName) {
		findByNameCheck(userName);
		List<Title> existing=repository.topTitle(movietv);
		if(existing==null)
		{
			throw new NotFoundException("There are no titles found of this type " + movietv);
		}
		return existing;
	}

}
