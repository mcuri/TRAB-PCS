package br.com.pcs.curso.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import br.com.pcs.curso.service.LoadUpdateXML;

public class ShowWindow extends JFrame {
	public ShowWindow() {
	}
	
	private JFrame window;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	
	private void buildWindow() {
		window = new JFrame("Secretaria UNIRIO");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(100, 100, 233, 311);
	
	}

	private void buildMainPanel() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		window.getContentPane().add(contentPane);
	}
	
	public void buildLoadXMLButton() {
		JButton loadXMLButton = new JButton("Load XML");
		loadXMLButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new LoadUpdateXML().loadAndUpdateXML();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(loadXMLButton);
	}
	
	public void buildExitButton() {
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		contentPane.add(exitButton,BorderLayout.EAST);
	}
	
	public void buildLabel(){
		lblNewLabel = new JLabel("Matricula: ");
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
	}
	public void buildTextBox() {
		textField = new JTextField();
		textField.setColumns(10);
		contentPane.add(textField, BorderLayout.WEST);
		
	}
	
	public void buildTable() {
		table = new JTable();
		table.setBorder(new LineBorder(Color.black));
		table.setGridColor(Color.black);
		table.setShowGrid(true);
		contentPane.add(table);
		
		scrollPane = new JScrollPane();
		scrollPane.getViewport().setBorder(null);
		scrollPane.getViewport().add(table);
		scrollPane.setSize(50,50);
		contentPane.add(scrollPane, BorderLayout.SOUTH);
		
	}

	public void showWindow() {
		//window.pack();
		window.setVisible(true);
		
	}
	
	public void buildAllComponets(){
		buildWindow();
		buildMainPanel();
		buildLoadXMLButton();
		buildExitButton();
		buildTable();
		buildLabel();
		buildTextBox();
		
		showWindow();
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowWindow window = new ShowWindow();
					window.buildAllComponets();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	
	
}
