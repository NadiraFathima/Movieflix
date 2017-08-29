package training.egen.rest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import training.egen.rest.entity.Users;

@Repository
public class UsersRepositoryImp implements UsersRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Users create(Users user) {
		System.out.println("Username exists1");
		em.persist(user);
		return user;

	}

	@Override
	public Users findOne(String userId) {
		return em.find(Users.class, userId);
		
	}
	@Override
	public Users update(Users user) {
		return em.merge(user);
	}

	@Override
	public void delete(Users user) {
	em.remove(user);	
	}

	@Override
	public boolean findByName(String userName, String password) {
		TypedQuery<Users> query=em.createNamedQuery("Users.findByName",Users.class);
		query.setParameter("pUserName",userName);
		
		Users user=query.getSingleResult();
			if(user.getPassword().equals(password)) {
			System.out.println("get password"+user.getPassword());
			System.out.println("entered password"+password);
				return true;
			}
		return false;
	}
	
	public List<Users> CheckuserName(String userName) {

		TypedQuery<Users> query=em.createNamedQuery("Users.findByName",Users.class);
		query.setParameter("pUserName",userName);
		
		List<Users> resultList=query.getResultList();
        
		if (resultList != null && resultList.size()==1) {
			return resultList;
		}
		else 
			return null;
	}

}
