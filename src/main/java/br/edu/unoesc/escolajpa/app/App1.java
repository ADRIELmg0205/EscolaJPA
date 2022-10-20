package br.edu.unoesc.escolajpa.app;


import br.edu.unoesc.escolajpa.model.Aluno;
import br.edu.unoesc.escolajpa.model.Curso;
import br.edu.unoesc.escolajpa.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class App1 {
private static EntityManager em;
	
	public static void main(String[] args) {
		em = JPAUtil.getEntityManager();
		
		Curso c1 = new Curso("Ciência da Computação");
		Curso c2 = new Curso("Administração");
		
		Aluno a1 = new Aluno("Beltrano", c1);
		Aluno a2 = new Aluno("Fulano", c1);
		Aluno a3 = new Aluno("Ciclano", c2);
		
		em.getTransaction().begin();
		
		em.persist(c1);
		em.persist(c2);
		
		em.persist(a1);
		em.persist(a2);		
		em.persist(a3);
		em.getTransaction().commit();
		
		em.close();
		JPAUtil.closeEntityManagerFactory();
	}
}
