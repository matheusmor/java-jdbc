package faeterj.banco.tela;

import java.awt.FlowLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import faeterj.banco.TestaBanco;

public class Contato extends JFrame {
	public Contato() throws SQLException {
		setTitle("Consultar Aluno");
		setLocationRelativeTo(null);
		
		JLabel lblSearch = new JLabel ("Pesquisar");
		JTextField txtSearch = new JTextField(30);
		JButton btnSearch = new JButton ("Pesquisar");
		String[] coluna ={"Matricula","Nome","Email","Celular"};
		
		Object[][] dados=  TestaBanco.getall();
		JTable tabela = new JTable( dados,coluna);
		
		
		
		JScrollPane barraRolagem = new JScrollPane();
		JButton btnClose = new JButton("fechar");
		
		JPanel p1 = new JPanel();
		BoxLayout bl = new BoxLayout(p1, BoxLayout.Y_AXIS);
		setContentPane(p1);
		p1.setLayout(bl);
		
		JPanel p2 = new JPanel();
		add(p2);
		p2.add(lblSearch);
		p2.add(txtSearch);
		p2.add(btnSearch);
		
		JPanel p3 = new JPanel();
		add(p3);
		
		barraRolagem.setViewportView(tabela);
		
		p3.add(barraRolagem);
		
		JPanel p4 = new JPanel(new FlowLayout(SwingConstants.RIGHT));
		add(p4);
		
		p4.add(btnClose);
		
		pack();

}
	}
