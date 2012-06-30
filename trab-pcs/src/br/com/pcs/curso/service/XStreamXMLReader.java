package br.com.pcs.curso.service;

import java.io.File;
import java.io.IOException;

import br.com.pcs.curso.model.Curso;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XStreamXMLReader {
	
	public Object read() throws IOException{
		  XStream stream = new XStream(new DomDriver());
		  Curso curso = (Curso) stream.fromXML(new File("curso.xml"));
		  XStreamXMLEncoder encoder = new XStreamXMLEncoder();
		  encoder.encode(curso, "result.xml");
		  return curso;
	}
	
	public static void main(String[] args) throws IOException {
		XStreamXMLReader reader = new XStreamXMLReader();
		reader.read();
		
	}

}
