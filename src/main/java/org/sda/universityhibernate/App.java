package org.sda.universityhibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.sda.universityhibernate.model.Professor;

public class App {
	
	private static SessionFactory sessionFactory;
	
	public static void main(String[] args) {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	
		List<Professor> professors = getAllProfessors();
		
		for(Professor professor : professors) {
			System.out.println(professor);
		}
		
		Professor prof = getProfessorById(1);
		System.out.println(prof);
		
		prof.setSalary(5000);
		updateProfessor(prof);
		
		Professor prof1 = getProfessorById(1);
		System.out.println(prof1);
		
		List<Professor> professors2 = getProfessorsByName("Mircea Radu");
		
		for(Professor professor : professors2) {
			System.out.println(professor);
		}
		
		sessionFactory.close();
	}
	
	private static List<Professor> getAllProfessors() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		List<Professor> professors = session.createQuery("from Professor").list();
		
		tx.commit();
		session.close();
		
		return professors;
	}
	
	private static Professor getProfessorById(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Professor professor = session.find(Professor.class, id);
		
		tx.commit();
		session.close();
		
		return professor;
	}
	
	private static void updateProfessor(Professor professor) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.update(professor);
		
		tx.commit();
		session.close();
	}
	
	private static List<Professor> getProfessorsByName(String name) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("from Professor where name=:nameParam");
		query.setParameter("nameParam", name);
		
		List<Professor> professors = query.list();
		
		tx.commit();
		session.close();
		
		return professors;
	}
	
	
}
