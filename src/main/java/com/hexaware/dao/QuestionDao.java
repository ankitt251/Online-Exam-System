package com.hexaware.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hexaware.model.Question;

public class QuestionDao {

	private SessionFactory factory;

	public QuestionDao() {
		factory = new Configuration().configure("exam.config.xml").addAnnotatedClass(Question.class)
				.buildSessionFactory();

	}

	public void addQuestions(Question que) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(que);
		transaction.commit();
		session.close();

	}

	public void updateQuestions(Question que) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(que);
		transaction.commit();
		session.close();
	}

	public Question getQuestionByNum(int questionNum) {
		Session session = factory.openSession();
		Question questions = session.createQuery("from Question where questionNum = :questionNum", Question.class)
				.setParameter("questionNum", questionNum).getSingleResult();
		session.close();
		return questions;
	}

	public void deleteQuestions(int questionNum) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Question que = session.createQuery("FROM Question WHERE questionNum = :questionNum", Question.class)
				.setParameter("questionNum", questionNum).uniqueResult();
		if (que != null) {
			session.delete(que);
			transaction.commit();
		}
		session.close();
	}

	public List<Question> getAllQuestions() {
		Session session = factory.openSession();
		List<Question> questions = session.createQuery("From Question", Question.class).list();
		session.close();
		return questions;
	}
}
