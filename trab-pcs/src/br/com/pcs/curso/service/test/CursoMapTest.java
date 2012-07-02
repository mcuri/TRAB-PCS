package br.com.pcs.curso.service.test;

import java.io.IOException;
import java.util.Set;

import br.com.pcs.curso.model.Aluno;
import br.com.pcs.curso.model.Curso;
import br.com.pcs.curso.model.Turma;
import br.com.pcs.curso.service.XMLReader;

public class CursoMapTest {

	public static void main(String[] args) throws IOException {
		XMLReader reader = new XMLReader();
		Curso curso = (Curso) reader.read();
		
		curso.printCodDisciplinaMap();
		curso.printMatriculaAlunoMap();
		curso.printTurmas();
		
		System.out.println("Turmas:  VAZIO????????????? ");
		for(Turma turma: curso.getTurmas()){
			System.out.println("Turma " + turma.getPeriodo());
			turma.printAlunoNotas();
		}
		
		/*for(String matricula: curso.getMatriculaAlunoMap().keySet()){
			Aluno aluno = curso.getMatriculaAlunoMap().get(matricula);
			System.out.println("Aluno: " + aluno.getNome());
			aluno.printTurmas();
			
		}*/
	
	}
}
