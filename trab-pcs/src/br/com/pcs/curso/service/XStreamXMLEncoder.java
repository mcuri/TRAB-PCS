package br.com.pcs.curso.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import br.com.pcs.curso.model.Aluno;
import br.com.pcs.curso.model.Curso;
import br.com.pcs.curso.model.Disciplina;
import br.com.pcs.curso.model.Turma;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XStreamXMLEncoder {
	
	public void encode(Object object, String file) throws IOException{
		
		XStream stream = new XStream(new DomDriver());
		/*stream.autodetectAnnotations(true);
		stream.processAnnotations(Aluno.class);
		stream.processAnnotations(Turma.class);
		stream.processAnnotations(Disciplina.class);
		stream.processAnnotations(Curso.class);
		//stream.setMode(XStream.NO_REFERENCES);
		stream.setMode(XStream.ID_REFERENCES);*/
		stream.toXML(object, new BufferedOutputStream(
								new FileOutputStream(file)));
		
	}

}
