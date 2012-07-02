package br.com.pcs.curso.service.test;

import java.io.IOException;

import br.com.pcs.curso.model.Aluno;
import br.com.pcs.curso.model.Curso;
import br.com.pcs.curso.service.FindAluno;
import br.com.pcs.curso.service.XMLReader;

public class FindAlunoTest {

public static void main(String[] args) throws IOException{
		
		XMLReader reader = new XMLReader();
		Curso curso = (Curso) reader.read();
		
		FindAluno findAluno = new FindAluno();
		Aluno aluno = findAluno.find("964521", curso);
		
		System.out.println("Qtd de disciplinas: " + aluno.getTurmas().size());
		System.out.println("Aluno: "+ findAluno.getNomeAluno(aluno));
		System.out.println("Aprovacoes: " +findAluno.getNumeroDeAprovacoes(aluno));
		System.out.println("Reprovacoes: "+ findAluno.getNumeroDeReprovacoes(aluno));
		System.out.println("Media geral: " + findAluno.getMediaGeral(aluno));
}
}
