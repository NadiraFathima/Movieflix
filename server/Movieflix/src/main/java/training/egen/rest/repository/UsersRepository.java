package training.egen.rest.repository;

import training.egen.rest.entity.Users;
import java.util.List;


public interface UsersRepository {

	public Users create(Users user);
	public Users findOne(String userId);
	public boolean findByName(String userName, String password);
	public List<Users> CheckuserName(String userName);
	public Users update(Users user);
	public void delete(Users user);

}
