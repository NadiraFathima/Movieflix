package training.egen.rest.repository;

import training.egen.rest.entity.Users;

public interface UsersRepository {

	public Users create(Users user);
	public Users findOne(String userId);
	public Users findByName(String userName);
	public Users update(Users user);
	public void delete(Users user);

}
