package training.egen.rest.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import training.egen.rest.entity.Users;
import training.egen.rest.exception.AlreadyExistsException;
import training.egen.rest.exception.NotFoundException;
import training.egen.rest.exception.PwdMisMatchException;
import training.egen.rest.repository.UsersRepository;

@Service
public class UsersServiceImp implements UsersService{

	@Autowired
	UsersRepository repository;
	
	@Override
	@Transactional
	public Users create(Users user) {
		Users existing=repository.findByName(user.getUserName());
		
		if(existing!=null)
		{
			throw new AlreadyExistsException("This Username is in use by other user. Choose any other name.");
		}
		
     if(!(user.getPassword().equals(user.getRepeatPassword())))
    	 throw new PwdMisMatchException("Password and repeat password do not match");
     
    	 return repository.create(user);
		
	}

	@Override
	public Users findOne(String userId) {
		Users existing=repository.findOne(userId);
		if(existing==null)
		{
			throw new NotFoundException("User with id:" + userId + "not found");
		}
		return existing;
	}
	
	
	
	@Override
	@Transactional
	public Users update(String userId,Users user) {
		Users existing=repository.findOne(userId);
		if(existing==null)
		{
			throw new NotFoundException("User with id: " + userId + " not found");
		}
		
		return repository.update(user);
	
	}

	@Override
	@Transactional
	public void delete(String userId) {
		Users existing=repository.findOne(userId);
		if(existing==null)
		{
			throw new NotFoundException("User with id: " + userId + " not found");
		}
	repository.delete(existing);
	}

}
