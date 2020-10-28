package faeterj.banco.tela;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SwingConstants;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

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
		
		TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tabela.getModel());
		tabela.setRowSorter(rowSorter);
		
		
		JScrollPane barraRolagem = new JScrollPane();
		JButton btnClose = new JButton("fechar");
		
		JPanel p1 = new JPanel();
		BoxLayout bl = new BoxLayout(p1, BoxLayout.Y_AXIS);
		setContentPane(p1);
		p1.setLayout(bl);
		
		
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String text =txtSearch.getText(); 
				if(text.trim().length()==0) {
					rowSorter.setRowFilter(null);
				}else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
				
			}
		});
		JPanel p2 = new JPanel();
		add(p2);
		p2.add(lblSearch);
		p2.add(txtSearch);
		p2.add(btnSearch);
		
		JPanel p3 = new JPanel();
		add(p3);
		
		barraRolagem.setViewportView(tabela);
		
		p3.add(barraRolagem);
		
		btnClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
			
		});
		JPanel p4 = new JPanel(new FlowLayout(SwingConstants.RIGHT));
		add(p4);
		
		p4.add(btnClose);
		
		pack();

}
	}
