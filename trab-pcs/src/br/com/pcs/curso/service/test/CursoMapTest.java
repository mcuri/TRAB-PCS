package br.com.pcs.curso.service.test;

import java.io.IOException;

import br.com.pcs.curso.model.Curso;
import br.com.pcs.curso.service.XMLReader;

public class CursoMapTest {

	public static void main(String[] args) throws IOException {
		XMLReader reader = new XMLReader();
		Curso curso = (Curso) reader.read();
		
		curso.printCodDisciplinaMap();
		curso.printMatriculaAlunoMap();
		curso.printTurmas();
	}
}
