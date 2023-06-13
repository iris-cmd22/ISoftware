package boundary;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DialogGenitore extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogGenitore dialog = new DialogGenitore();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogGenitore() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 0, 139));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btn_visualizzaVoti = new JButton("Visualizza Voti");
			btn_visualizzaVoti.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					DialogVisualizzaVoti fd = new DialogVisualizzaVoti(); //apri il jDialog VisualizzaVoti
					fd.show(); //display dialog nuovo
					
					dispose();//chiudi il JDialog corrente dopo aver aperto il nuovo
				}
			});
			btn_visualizzaVoti.setBounds(91, 89, 250, 86);
			btn_visualizzaVoti.setForeground(new Color(0, 0, 0));
			btn_visualizzaVoti.setBackground(new Color(255, 255, 255));
			btn_visualizzaVoti.setFont(new Font("Tahoma", Font.BOLD, 14));
			contentPanel.add(btn_visualizzaVoti);
		}
		{
			JLabel lbl_genitore = new JLabel("GENITORE");
			lbl_genitore.setBounds(5, 5, 426, 19);
			lbl_genitore.setForeground(new Color(255, 255, 255));
			lbl_genitore.setBackground(new Color(0, 0, 139));
			lbl_genitore.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			contentPanel.add(lbl_genitore);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}

}
