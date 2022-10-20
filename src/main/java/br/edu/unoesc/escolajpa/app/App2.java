package br.edu.unoesc.escolajpa.app;

import java.util.List;

import br.edu.unoesc.escolajpa.dao.AlunoDAO;
import br.edu.unoesc.escolajpa.dao.CursoDAO;
import br.edu.unoesc.escolajpa.model.Aluno;
import br.edu.unoesc.escolajpa.model.Curso;

public class App2 {
	public static void main(String[] args) {

		CursoDAO cursoDAO = new CursoDAO();

		Curso curso1 = new Curso("Ciência da Computação");
		Curso curso2 = new Curso("Administração");

		cursoDAO.salvar(curso1).salvar(curso2);

		AlunoDAO alunoDAO = new AlunoDAO();
		Aluno aluno1 = new Aluno("Beltrano", curso1);
		Aluno aluno2 = new Aluno("Fulano", curso1);
		Aluno aluno3 = new Aluno("Ciclano", curso2);

		alunoDAO.salvar(aluno1).salvar(aluno2).salvar(aluno3);

		System.out.println(alunoDAO.buscarPorId(1));
		System.out.println(alunoDAO.buscarPorId(2));

		List<Aluno> alunos = alunoDAO.obterTodos();
		System.out.println("Aluno\tCurso");
		for (Aluno a : alunos) {
			System.out.println(a.getNome() + "\t\t" + a.getCurso().getNome());
		}

		List<Curso> cursos = cursoDAO.obterTodos();
		System.out.println("Cargos e Funcionarios");
		for (Curso c : cursos) {
			System.out.println(c.getNome());
			for (Aluno a : c.getAlunos()) {
				System.out.println("\t" + a.getNome());
			}
		}

		cursoDAO.fechar();
		alunoDAO.fechar();

	}
}
