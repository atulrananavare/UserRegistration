package userRegistration.com.demo.dao;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Repository;

import userRegistration.com.demo.entity.User;

@Repository
public class UserDAoImpl implements UserDAO {
	private EntityManager entityManager;

	@Autowired
	public UserDAoImpl(EntityManager theEntityManager) {
		this.entityManager = theEntityManager;
	}

	@Override
	public List<User> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<User> theQuery = currentSession.createQuery("from User", User.class);

		List<User> users = theQuery.getResultList();

		return users;
	}

	@Override
	public User findById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		User theUser = currentSession.get(User.class, theId);
		return theUser;
	}

	@Override
	public void save(User theUser) {
		Session currentSession = entityManager.unwrap(Session.class);

		currentSession.saveOrUpdate(theUser);
	}

	@Override
	public void deleteById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);

		Query theQuery = currentSession.createQuery("delete from User where id=:user_id");

		theQuery.setParameter("user_id", theId);

		theQuery.executeUpdate();
	}

	@Override
	public void updatePartialUser(int theId, Map<Object, Object> fields) {
		Session currentSession = entityManager.unwrap(Session.class);
		User theUser = currentSession.get(User.class, theId);
		
		fields.forEach((key,value) -> {
			Field field=ReflectionUtils.findRequiredField(User.class, (String) key);
			field.setAccessible(true);
			ReflectionUtils.setField(field, theUser, value);
		});
		
	    currentSession.saveOrUpdate(theUser);
		
		
	}

}
