package com.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;



public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Transaction tr=null;
       try(Session ses=HBUtil.getSesFactory().openSession()){
    	   tr=ses.beginTransaction();
    	   Question q1=new Question();
    	   q1.setQuestion("What is Hibernate?");
    	   Question q2=new Question();
    	   q2.setQuestion("What is Entity class?");
    	   Answer a1=new Answer(101,"Hb is an ORM","Saranya");
    	   Answer a2=new Answer(102,"Hb implements JPA","Rohan");
    	   Answer b1=new Answer(201,"Entity class is a simple java class","Sudiksha");
    	   Answer b2=new Answer(202,"POJO classess are called as Entity class","Heshvika");
    	   List<Answer> l1=new ArrayList<Answer>();
    	   l1.add(a1);
    	   l1.add(a2);
    	   List<Answer> l2=new ArrayList<Answer>();
    	   l2.add(b1);
    	   l2.add(b2);
    	   q1.setAnswers(l1);
    	   q2.setAnswers(l2);
    	   ses.merge(q1);ses.merge(q2);
    	   tr.commit();
    	   ses.close();
    	   
    	   
    	   
       }
       catch(Exception e) {e.printStackTrace();}
	}

}
