package modelo;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import faeterj.banco.TestaBanco;

public class NovoAluno extends JFrame {

	public NovoAluno() {
		setTitle("novo aluno");
		setLocationRelativeTo(null);
		JLabel lblNome = new JLabel("Nome");
		JLabel lblMatricula = new JLabel("Matricula");
		JLabel lblEmail = new JLabel("Email");
		JLabel lblCelular = new JLabel("Celular");
		
		JTextField txtNome = new JTextField(20);
		JTextField txtMatricula = new JTextField(20);
		JTextField txtEmail= new JTextField(20);
		JTextField	txtCelular =new JTextField(20);
		
		JButton btnsave = new JButton ("salvar");
		JButton btnCancel = new JButton ("cancelar");
		
		JPanel p1 = new JPanel();
		BoxLayout bl = new BoxLayout(p1, BoxLayout.Y_AXIS);
		setContentPane(p1);
		p1.setLayout(bl);
		
		JPanel p2 = new JPanel();
		add(p2);
		GridLayout l2 = new GridLayout(0, 2,2,2);

		p2.setLayout(l2);
		
		
		
		p2.add(lblNome);
		p2.add(txtNome);
		p2.add(lblMatricula);
		p2.add(txtMatricula);
		p2.add(lblEmail);
		p2.add(txtEmail);
		p2.add(lblCelular);
		p2.add(txtCelular);

		btnsave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String nome =txtNome.getText();
					String matricula = txtMatricula.getText();
					String email = txtEmail.getText();
					String celular = txtCelular.getText();
					TestaBanco.newAluno(nome, matricula, email, celular);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		JPanel p3 = new JPanel();
		add(p3);
		p3.add(btnCancel);
		p3.add(btnsave);
		
		
		pack();
		
	}
}
