package com.simplilearn.demo;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionsService {
	
	
	@Autowired
	private QuestionsRepo repo;
	
	@Autowired
	private QuizRepo repo1;
	
	//add method or CREATE RECORD
	public Questions addQuestion(Questions q) {
		
		return repo.save(q);
	}

	//get all questions
	public List<Questions> getAllQuestion() {
		
		return repo.findAll();
	}

		//delete Question
	public boolean deleteQuestion(int id) {

			if(repo.findById(id).isPresent())
			{
				repo.deleteById(id);
				return true;
			}
			else
				return false;
		}

	public Questions getQuestionById(int id) {
		if(repo.findById(id).isPresent()) 
			return repo.findById(id).get();
		else 
			return null;
	}
	
	//creating quizz
	public Quiz addQuiz(Quiz q) {
		
		return repo1.save(q);
	}
	

}