package prototype;

import java.awt.*;
import javax.swing.*;
import java.io.*;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Extract extends JFrame {

	 public String encryptedAudioFileName;
	    public String encryptedAudioFileDirectory;
	    public String encryptedAudioFileString;
	    
	private JPanel contentPane;
	private JButton btnEncryptedFile;
	private JButton btnExtractText;
	private JButton btnFinish;
	private JLabel lblFileNotChosen;
	private JPasswordField passwordField;
	private JLabel lblPasswordToDecrypt;
	private JLabel lblOutputLocation;
	private JTextArea showText;
	private JButton btnGoBack;
	private JLabel lblUnhideYourText;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Extract frame = new Extract();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Extract() {
		setTitle("Unhide Text from Audio File");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 748, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnEncryptedFile());
		contentPane.add(getBtnExtractText());
		contentPane.add(getBtnFinish());
		contentPane.add(getLblFileNotChosen());
		contentPane.add(getPasswordField());
		contentPane.add(getLblPasswordToDecrypt());
		contentPane.add(getLblOutputLocation());
		contentPane.add(getShowText());
		contentPane.add(getBtnGoBack());
		contentPane.add(getLblUnhideYourText());
		contentPane.add(getBtnNewButton());
	}

	private JButton getBtnEncryptedFile() {
		if (btnEncryptedFile == null) {
			btnEncryptedFile = new JButton("Encrypted File");
			btnEncryptedFile.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnEncryptedFileActionPerformed(e);
					
				}
			});
			btnEncryptedFile.setBounds(24, 68, 142, 23);
		}
		return btnEncryptedFile;
	}
	
	public void btnEncryptedFileActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JFileChooser encryptedAudioChooser= new JFileChooser();
		int returnVal = encryptedAudioChooser.showOpenDialog(this);
        if (returnVal == 0) {
            File file = encryptedAudioChooser.getSelectedFile();
            
            this.encryptedAudioFileName = file.getName();
            this.encryptedAudioFileDirectory = file.getParent();

            this.encryptedAudioFileString = file.getAbsolutePath();
            this.lblFileNotChosen.setText(this.encryptedAudioFileString);
        } else {
            System.out.println("File access cancelled by user.");
        }
//        this.playButton.setEnabled(true);
	}

	private JButton getBtnExtractText() {
		if (btnExtractText == null) {
			btnExtractText = new JButton("Extract Text");
			btnExtractText.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnExtractText.setBounds(24, 218, 142, 23);
		}
		return btnExtractText;
	}
	private JButton getBtnFinish() {
		if (btnFinish == null) {
			btnFinish = new JButton("Finish");
			btnFinish.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnFinish.setBounds(24, 396, 142, 23);
		}
		return btnFinish;
	}
	private JLabel getLblFileNotChosen() {
		if (lblFileNotChosen == null) {
			lblFileNotChosen = new JLabel("File not Chosen");
			lblFileNotChosen.setBounds(240, 72, 497, 14);
		}
		return lblFileNotChosen;
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(24, 171, 142, 23);
		}
		return passwordField;
	}
	private JLabel getLblPasswordToDecrypt() {
		if (lblPasswordToDecrypt == null) {
			lblPasswordToDecrypt = new JLabel("Password to Decrypt");
			lblPasswordToDecrypt.setBounds(240, 175, 123, 14);
		}
		return lblPasswordToDecrypt;
	}
	private JLabel getLblOutputLocation() {
		if (lblOutputLocation == null) {
			lblOutputLocation = new JLabel("Output Location");
			lblOutputLocation.setBounds(240, 222, 497, 14);
		}
		return lblOutputLocation;
	}
	private JTextArea getShowText() {
		if (showText == null) {
			showText = new JTextArea();
			showText.setText("encrypted text");
			showText.setBounds(26, 252, 430, 115);
		}
		return showText;
	}
	private JButton getBtnGoBack() {
		if (btnGoBack == null) {
			btnGoBack = new JButton("Go Back");
			btnGoBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnGoBack.setBounds(240, 396, 120, 23);
		}
		return btnGoBack;
	}
	private JLabel getLblUnhideYourText() {
		if (lblUnhideYourText == null) {
			lblUnhideYourText = new JLabel("Unhide your Text from Audio File");
			lblUnhideYourText.setForeground(new Color(0, 51, 153));
			lblUnhideYourText.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
			lblUnhideYourText.setBounds(24, 23, 365, 23);
		}
		return lblUnhideYourText;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Play Audio\r\n");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnNewButton.setBounds(24, 115, 142, 23);
		}
		return btnNewButton;
	}
}
