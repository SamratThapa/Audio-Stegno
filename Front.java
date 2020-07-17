package prototype;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.filechooser.*;



import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Front {
	//------------
//	public static int embedJIFX = 0;
//    public static int embedJIFY = 0;
//    public static int extractJIFX = 600;
//    public static int extractJIFY = 0;
	//----

	private JFrame frmAudioSteganographyGroup;
	private JButton btnExtract;
	private JButton btnEmbed;
	private JLabel l;
	private JLabel lblUnhideTextFrom;
	private JLabel lblAudioSteganography;
	private JButton btnHelp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Front window = new Front();
					window.frmAudioSteganographyGroup.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Front() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAudioSteganographyGroup = new JFrame();
		frmAudioSteganographyGroup.setTitle("Audio Steganography Group I");
		frmAudioSteganographyGroup.setBounds(100, 100, 450, 339);
		frmAudioSteganographyGroup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAudioSteganographyGroup.getContentPane().setLayout(null);
		frmAudioSteganographyGroup.getContentPane().add(getBtnExtract());
		frmAudioSteganographyGroup.getContentPane().add(getBtnEmbed());
		frmAudioSteganographyGroup.getContentPane().add(getL());
		frmAudioSteganographyGroup.getContentPane().add(getLblUnhideTextFrom());
		frmAudioSteganographyGroup.getContentPane().add(getLblAudioSteganography());
		frmAudioSteganographyGroup.getContentPane().add(getBtnHelp());
	}
	private JButton getBtnExtract() {
		if (btnExtract == null) {
			btnExtract = new JButton("Extract");
			btnExtract.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Extract frame = new Extract();
					frame.setVisible(true);
				}
			});
			btnExtract.setBounds(228, 167, 106, 23);
		}
		return btnExtract;
	}
	private JButton getBtnEmbed() {
		if (btnEmbed == null) {
			btnEmbed = new JButton("Embed");
			
			btnEmbed.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					
					Embed frame=new Embed();
					frame.setVisible(true);
					
					

      } 
			  
				
			});
			btnEmbed.setBounds(228, 93, 106, 23);
		}
		return btnEmbed;
	}
	private JLabel getL() {
		if (l == null) {
			l = new JLabel("Hide Text In Audio");
			l.setBounds(50, 97, 181, 14);
		}
		return l;
	}
	private JLabel getLblUnhideTextFrom() {
		if (lblUnhideTextFrom == null) {
			lblUnhideTextFrom = new JLabel("Unhide Text From Audio");
			lblUnhideTextFrom.setBounds(50, 171, 168, 14);
		}
		return lblUnhideTextFrom;
	}
	private JLabel getLblAudioSteganography() {
		if (lblAudioSteganography == null) {
			lblAudioSteganography = new JLabel("Audio Steganography");
			lblAudioSteganography.setForeground(new Color(0, 51, 153));
			lblAudioSteganography.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 17));
			lblAudioSteganography.setBounds(50, 24, 331, 42);
		}
		return lblAudioSteganography;
	}
	private JButton getBtnHelp() {
		if (btnHelp == null) {
			btnHelp = new JButton("Help");
			btnHelp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Help frame = new Help();
					frame.setVisible(true);
					
				}
			});
			btnHelp.setBounds(228, 238, 106, 23);
		}
		return btnHelp;
	}
}
