package com.hexaware.service;

import java.util.Scanner;

import com.hexaware.dao.QuestionDao;
import com.hexaware.model.Question;

public class QuestionService {
	static Scanner scanner = new Scanner(System.in);
	QuestionDao questionDao = new QuestionDao();

	public void addQuestions() {
		System.out.println("Enter Question: ");
		String question = scanner.nextLine();
		System.out.println("Enter Option A: ");
		String optionA = scanner.nextLine();
		System.out.println("Enter Option B: ");
		String optionB = scanner.nextLine();
		System.out.println("Enter Option C: ");
		String optionC = scanner.nextLine();
		System.out.println("Enter Option D: ");
		String optionD = scanner.nextLine();
		System.out.println("Enter Answer: ");
		String answer = scanner.nextLine();
		Question que = new Question(question, optionA, optionB, optionC, optionD, answer);
		questionDao.addQuestions();
		System.out.println("Question added successfully!");
	}

	public void updateQuestions() {

	}

	public void deleteQuestions() {

	}
}
