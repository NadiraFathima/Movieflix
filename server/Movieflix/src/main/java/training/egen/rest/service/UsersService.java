package training.egen.rest.service;


import training.egen.rest.entity.Users;

public interface UsersService {

	public Users update(String userId,Users user);
	public Users findOne(String userId);
	public String findByName(String userName, String password);
	public void delete(String userId);
	public Users create(Users user);

}
