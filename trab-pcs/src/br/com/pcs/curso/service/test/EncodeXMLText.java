package br.com.pcs.curso.service.test;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import br.com.pcs.curso.model.Disciplina;

public class EncodeXMLText {

	public static void main(String[] args) throws IOException {
		
		Disciplina d =  new Disciplina("111", "Analise de Algoritmos");
		
		XMLEncoder e = new XMLEncoder(
                new BufferedOutputStream(
                    new FileOutputStream("Test.xml")));
		
		e.writeObject(d);
		e.close();
		
		/*XMLEncoderToFile xmlEncoder = new XMLEncoderToFile();
		xmlEncoder.generate(aluno);*/
	}
}
