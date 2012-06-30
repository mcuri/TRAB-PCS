package br.com.pcs.curso.service.test;

import br.com.pcs.curso.model.Disciplina;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class EncodeWithXStreamTest {

	public static void main(String[] args) {
		
		Disciplina d =  new Disciplina("111", "Analise de Algoritmos");
		
		XStream stream = new XStream(new DomDriver());
		System.out.println(stream.toXML(d));
	}
}
