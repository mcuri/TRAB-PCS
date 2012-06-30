package br.com.pcs.curso.service;

import java.io.IOException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.com.pcs.curso.model.Aluno;
import br.com.pcs.curso.model.Disciplina;
import br.com.pcs.curso.model.Turma;

public class XMLTest {

	public static void main(String[] args) throws IOException{
		
		Disciplina d1 = new Disciplina("SI1", "PROGRAMACAO MODULAR");
		Disciplina d2 = new Disciplina("SI2", "SISTEMAS COLABORATIVOS");
		Turma turma1 = new Turma(d1, "2012.1");
		Turma turma2 = new Turma(d2, "2011.2");
		Aluno aluna = new Aluno("2010125", "Mariana Curi");
		aluna.addTurma(turma1);
		aluna.addTurma(turma2);
		Aluno aluno = new Aluno("2010589", "Davi Alves");
		
		/*XMLEncoderToFile encoder = new XMLEncoderToFile();
		encoder.generate(aluna);*/
		
		XStream stream = new XStream(new DomDriver());
		stream.autodetectAnnotations(true);
		stream.processAnnotations(Aluno.class);
		stream.processAnnotations(Turma.class);
		System.out.println(stream.toXML(aluna));
		
		
		
		
	}
}
