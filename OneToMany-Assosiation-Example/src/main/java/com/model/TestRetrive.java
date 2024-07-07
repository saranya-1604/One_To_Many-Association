package com.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import org.hibernate.query.Query;


public class TestRetrive {

	public static void main(String[] args) {
		
		
				// TODO Auto-generated method stub
				Transaction tr=null;
				try(Session ses=HBUtil.getSesFactory().openSession()){
					tr=ses.beginTransaction();
				
		       Query<Question> qry=ses.createQuery("from Question",Question.class);
		       List<Question> li=qry.list();
		       for(Question e:li) {
		       System.out.println(e.getId()+" "+e.getQuestion()+" "+e.getAnswers());
		       List<Answer> ad=e.getAnswers();
		       for(Answer as:ad) {
		       System.out.println("Answers are....");
		       System.out.println( as.getAnswername()+" "+ as.getPostedBy()+" "+ as.getId());
			}
		       }
		       tr.commit();
		       ses.close();
		       }
				catch(Exception e) {e.printStackTrace();}

		}

	}


