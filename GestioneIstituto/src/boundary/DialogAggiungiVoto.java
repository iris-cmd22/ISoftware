import control.Controller;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DialogAggiungiVoto extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_matricola;
	private JTextField textField_materia;
	


	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DialogAggiungiVoto dialog = new DialogAggiungiVoto();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		});
	}

	/**
	 * Create the dialog.
	 */
	public DialogAggiungiVoto() {
		//setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 429, 355);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_AggiungiVoto = new JLabel("Aggiungi Voto");
		lbl_AggiungiVoto.setForeground(new Color(255, 255, 255));
		lbl_AggiungiVoto.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
		lbl_AggiungiVoto.setBounds(10, 10, 197, 19);
		contentPane.add(lbl_AggiungiVoto);
		
		JLabel lbl_matricola = new JLabel("Matricola");
		lbl_matricola.setForeground(new Color(255, 255, 255));
		lbl_matricola.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbl_matricola.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_matricola.setBounds(25, 123, 60, 13);
		contentPane.add(lbl_matricola);
		
		textField_matricola = new JTextField();
		textField_matricola.setBounds(111, 119, 145, 19);
		contentPane.add(textField_matricola);
		textField_matricola.setColumns(10);
		
		
		JLabel lbl_data = new JLabel("Data");
		lbl_data.setForeground(new Color(255, 255, 255));
		lbl_data.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbl_data.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_data.setBounds(25, 176, 60, 13);
		contentPane.add(lbl_data);
		
		JLabel lbl_voto = new JLabel("Voto");
		lbl_voto.setForeground(new Color(255, 255, 255));
		lbl_voto.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbl_voto.setBounds(39, 218, 48, 14);
		contentPane.add(lbl_voto);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		dateChooser.setBounds(111, 169, 145, 20);
		contentPane.add(dateChooser);
		
	
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		spinner.setBounds(111, 215, 145, 20);
		contentPane.add(spinner);
		
		JLabel lbl_materia = new JLabel("Materia");
		lbl_materia.setForeground(new Color(255, 255, 255));
		lbl_materia.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbl_materia.setBounds(37, 70, 48, 14);
		contentPane.add(lbl_materia);
		
		textField_materia = new JTextField();
		textField_materia.setBounds(111, 67, 145, 20);
		contentPane.add(textField_materia);
		textField_materia.setColumns(10);
		
		JButton btnAggiungiVoto = new JButton("AGGIUNGI");
		btnAggiungiVoto.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAggiungiVoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAggiungiVoto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int ret=-1;
			
				
				String matricola = textField_matricola.getText();
				String materia = textField_materia.getText();
				java.util.Date data = dateChooser.getDate();
				int voto = (int) spinner.getValue();
				
				ret=Controller.aggiungiVoto(Integer.parseInt(matricola),Integer.parseInt(materia),(Date) data, voto);
				
				if(ret!=-1) {
					
					JOptionPane.showMessageDialog(btnAggiungiVoto, "Testo inserito correttamente", "Plain Text", JOptionPane.PLAIN_MESSAGE);


				}else {
					
					JOptionPane.showMessageDialog(btnAggiungiVoto, "Inserimennto non andato a buon fine", "Error", JOptionPane.ERROR_MESSAGE);

				}
				

				
				
			}
		});
		btnAggiungiVoto.setBounds(251, 264, 112, 23);
		contentPane.add(btnAggiungiVoto);
		
		

	}
}
