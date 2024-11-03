package com.hexaware.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hexaware.model.User;

public class UserDao {
	private SessionFactory factory;

	public UserDao() {
		factory = new Configuration().configure("exam.config.xml").addAnnotatedClass(User.class).buildSessionFactory();
	}

	public void registerUser(User user) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
	}

	public User getUser(String email) {
		Session session = factory.openSession();
		return session.createQuery("from User where email = :email", User.class).setParameter("email", email)
				.getSingleResult();
	}

	public void logoutAllUsers() {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.createQuery("update User set isLoggedIn = false").executeUpdate();
		transaction.commit();
		session.close();
	}

	public void updateUser(User user) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(user);
		transaction.commit();
		session.close();
	}

	public void deleteUser(User user) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(user);
		transaction.commit();
		session.close();
	}

}
