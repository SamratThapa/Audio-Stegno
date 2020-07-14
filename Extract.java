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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
	}

	private JButton getBtnEncryptedFile() {
		if (btnEncryptedFile == null) {
			btnEncryptedFile = new JButton("Encrypted File");
			btnEncryptedFile.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnEncryptedFileActionPerformed(e);
					
				}
			});
			btnEncryptedFile.setBounds(10, 31, 142, 23);
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
			btnExtractText.setBounds(10, 140, 142, 23);
		}
		return btnExtractText;
	}
	private JButton getBtnFinish() {
		if (btnFinish == null) {
			btnFinish = new JButton("Finish");
			btnFinish.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnFinish.setBounds(10, 207, 142, 23);
		}
		return btnFinish;
	}
	private JLabel getLblFileNotChosen() {
		if (lblFileNotChosen == null) {
			lblFileNotChosen = new JLabel("File not Chosen");
			lblFileNotChosen.setBounds(185, 35, 239, 14);
		}
		return lblFileNotChosen;
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(10, 89, 142, 23);
		}
		return passwordField;
	}
	private JLabel getLblPasswordToDecrypt() {
		if (lblPasswordToDecrypt == null) {
			lblPasswordToDecrypt = new JLabel("Password to Decrypt");
			lblPasswordToDecrypt.setBounds(185, 93, 123, 14);
		}
		return lblPasswordToDecrypt;
	}
	private JLabel getLblOutputLocation() {
		if (lblOutputLocation == null) {
			lblOutputLocation = new JLabel("Output Location");
			lblOutputLocation.setBounds(185, 144, 220, 14);
		}
		return lblOutputLocation;
	}
}
