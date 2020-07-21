package prototype;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileSystemView;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.filechooser.FileFilter;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import java.awt.Font;
import java.awt.Color;

public class Embed extends JFrame {

	public String inputPasswordString;
	//private BackEndHandler back;
	 public String inputAudioFileName;
	    public String inputAudioFileDirectory;
	    public String inputAudioFileString;
	    public String inputTextAreaString;
	    public File tempFile;
	    public String outputAudioFileString;
	   // private Audio audio;

	    public String inputTextFileString;
	
	private JPanel contentPane;
	private JButton btnInput;
	private JButton btnText;
	private JLabel label;
	private JButton btnOutput;
	private JButton btnFinish;
	private JLabel label1;
	private JLabel labelout;
	private JPasswordField passwordField;
	private JLabel lblPasswordToEncrypt;
	private JRadioButton rdbtnTextFile;
	private JRadioButton rdbtnWriteText;
	private JTextArea txtArea;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnGoBack;
	private JLabel lblNewLabel;
	private JButton btnPlayAudio;
	private JButton btnStopAudio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Embed frame = new Embed();
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
	public Embed() {
		setTitle("Hide text in Audio File");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 743, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnInput());
		contentPane.add(getBtnText());
		contentPane.add(getLabel());
		contentPane.add(getBtnOutput());
		contentPane.add(getBtnFinish());
		contentPane.add(getLabel1());
		contentPane.add(getLabelout());
		contentPane.add(getPasswordField());
		contentPane.add(getLblPasswordToEncrypt());
		contentPane.add(getRdbtnTextFile());
		contentPane.add(getRdbtnWriteText());
		contentPane.add(getTxtArea());
		contentPane.add(getBtnGoBack());
		contentPane.add(getLblNewLabel());
		contentPane.add(getBtnPlayAudio());
		contentPane.add(getBtnStopAudio());
		
		
	}

	private JButton getBtnInput() {
		if (btnInput == null) {
			btnInput = new JButton("Input Audio File");
			btnInput.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					Embed.this.btnInputActionPerformed(evt);

				}
			});
			btnInput.setBounds(42, 67, 143, 23);
		}
		return btnInput;
	}
	public void btnInputActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		//---------------------javapoint------------------------------------------------------------------
//		JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
//		j.setFileSelectionMode(JFileChooser.FILES_ONLY);
//        j.setAcceptAllFileFilterUsed(false);
//        j.addChoosableFileFilter(new FileFilter() {
//            @Override
//            public boolean accept(File f) {
//                return f.isDirectory() || f.getName().toLowerCase().endsWith(".au");
//            }
//
//            @Override
//            public String getDescription() {
//                return "Audio (*.au)";
//            }
//        });
////		  
////          // invoke the showsOpenDialog function to show the save dialog 
//         int r = j.showOpenDialog(null); 
//       // if the user selects a file 
//          if (r == JFileChooser.APPROVE_OPTION) 
//
//          { 
////              // set the label to the path of the selected file 
//        	  inputAudioFileString=  j.getSelectedFile().getAbsolutePath();
//        	  label1.setText(inputAudioFileString);
//             //label1.setText(j.getSelectedFile().getAbsolutePath()); 
//          } 
////          // if the user cancelled the operation 
//          else
//              label1.setText("the user cancelled the operation"); 
//--------------------------------------------------------------------------------------------
		JFileChooser inputAudioChooser = new JFileChooser();
		int returnVal = inputAudioChooser.showOpenDialog(this);
        if (returnVal == 0) {
            File file = inputAudioChooser.getSelectedFile();
            this.inputAudioFileName = file.getName();
            this.inputAudioFileDirectory = file.getParent();

            this.inputAudioFileString = file.getAbsolutePath();
            label1.setText(this.inputAudioFileString);
        } else {
            System.out.println("File access cancelled by user.");
        }
        
    }
	
	//------------------------------------------------------------------------------------------------

	private JButton getBtnText() {
		if (btnText == null) {
			btnText = new JButton("Input Text File");
			btnText.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					Embed.this.btnTextActionPerformed(evt);
				}
			});
			btnText.setBounds(42, 201, 143, 23);
		}
		return btnText;
	}
	public void btnTextActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
	//----------------javapoint-------------------------------------------------------------------
//		JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
//		j.setFileSelectionMode(JFileChooser.FILES_ONLY);
//        j.setAcceptAllFileFilterUsed(false);
//        j.addChoosableFileFilter(new FileFilter() {
//            @Override
//            public boolean accept(File f) {
//                return f.isDirectory() || f.getName().toLowerCase().endsWith(".txt");
//            }
//
//            @Override
//            public String getDescription() {
//                return "Text Files (*.txt)";
//            }
//        });
////		  
////        // invoke the showsOpenDialog function to show the save dialog 
//       int r = j.showOpenDialog(null); 
//     // if the user selects a file 
//        if (r == JFileChooser.APPROVE_OPTION) 
//
//        { 
////            // set the label to the path of the selected file 
//        	 inputTextFileString=  j.getSelectedFile().getAbsolutePath();
//       	  label.setText(inputTextFileString);
//           //label.setText(j.getSelectedFile().getAbsolutePath()); 
//        } 
////        // if the user cancelled the operation 
//        else
//            label.setText("the user cancelled the operation"); 
//---------------------------------------------------------------------------------------
		JFileChooser inputTextChooser = new JFileChooser();
		int returnVal = inputTextChooser.showOpenDialog(this);
        if (returnVal == 0) {
            File file = inputTextChooser.getSelectedFile();

            inputTextFileString = file.getAbsolutePath();
            this.label.setText(inputTextFileString);
        } else {
            System.out.println("File access cancelled by user.");
        }
	}

	

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("File not chosen");
			label.setBounds(240, 205, 420, 14);
		}
		return label;
	}
	private JButton getBtnOutput() {
		if (this.btnOutput == null) {
			this.btnOutput = new JButton("Output");
			this.btnOutput.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent et) {
					Embed.this.btnOutputActionPerformed(et);
//					btnOutputActionPerformed(et);
				}
			});
			this.btnOutput.setBounds(42, 410, 143, 23);
		}
		return this.btnOutput;
	}//-------------------------------------------------------------------------------------------
	@SuppressWarnings("deprecation") //for getText in password
	public  void btnOutputActionPerformed(ActionEvent et) {
		// TODO Auto-generated method stub
		//------------------------------------------------------------------------------
	
        
		
		this.inputPasswordString = this.passwordField.getText(); //suppresswarnings
        this.inputTextAreaString = this.txtArea.getText();
        //----------------------------------------------------------------------
//take reference from deskstop project embed.java for this part
		//------------------------------------------------------------------------------------------------
        
        Boolean encryptOrNot = null;

        Boolean txtS = Boolean.valueOf(this.rdbtnWriteText.isSelected());
        if (txtS.booleanValue()) {
            if (this.inputTextAreaString.equals("")) {
                encryptOrNot = Boolean.valueOf(false);
            } else {
                encryptOrNot = Boolean.valueOf(true);
                try {
                    this.tempFile = File.createTempFile("AudioSteganographypyTemp" /*+ this.pEmbedJIFNo*/, ".txt");
                } catch (IOException ex) {
                    
                }
                BufferedWriter output = null;
                try {//-------------------------------------------------
                    output = new BufferedWriter(new FileWriter(this.tempFile));
                    output.write(this.inputTextAreaString);
                    output.close();
                    //---------------------------------------------------------------
                } catch (IOException ex) {
                    
                }
            }//-------------------------------------------------------------------------
        } else if (inputTextFileString != null) {
            encryptOrNot = Boolean.valueOf(true);
        } else {
            encryptOrNot = Boolean.valueOf(false);
        }
        System.out.println("Audio : " + this.inputAudioFileString + "\nAudioDIR : " + this.inputAudioFileDirectory + "\nFileName : " + this.inputAudioFileName + "\nTextFile : " + inputTextFileString + "\nPassword : " + this.inputPasswordString + "\n" + "Output AudioFile : " + this.outputAudioFileString);
        if ((this.inputAudioFileString != null) && (encryptOrNot.booleanValue()) && (!this.inputPasswordString.equals(""))) {
            this.btnOutput.setEnabled(false);
            this.outputAudioFileString = this.inputAudioFileDirectory.concat("/Encrypted-" + this.inputAudioFileName);
            if (txtS.booleanValue()) {
                inputTextFileString = this.tempFile.getAbsolutePath();
                System.out.println("\nTemp Automatic : " + inputTextFileString);
            }
            this.labelout.setText(this.outputAudioFileString);

            Steganography e = new Steganography(this.inputAudioFileString, inputTextFileString, this.outputAudioFileString, this.inputPasswordString.toCharArray());
            e.encode();
            this.btnFinish.setEnabled(true);
            try {
                this.tempFile.deleteOnExit();
            } catch (Exception ex) {
            }
        } else {
        	//if neither the text file or text in textarea or audio file the instructions in message dialog
            JOptionPane.showMessageDialog(this, "1. Select Audio File\n2. Write Text or Select Text File\n3. Enter Password.", "Something is missing !", 0);
        }
    }
        
		//--------------------------without radiobutton------------------------------------------------------------------------
//		try {
//			this.tempFile = File.createTempFile("AudioSteganographypyTemp" + this.pEmbedJIFNo, ".txt");
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//             inputTextFileString = this.tempFile.getAbsolutePath();
//             System.out.println("\nTemp Automatic : " + inputTextFileString);
//         
//         labelout.setText(this.outputAudioFileString);
//
//         Steganography e = new Steganography(this.inputAudioFileString, inputTextFileString, this.outputAudioFileString);
//         e.encode();
//         //btnFinish.setEnabled(true);
//         try {
//             tempFile.deleteOnExit();
//         } catch (Exception ex) {
//         }
//        }
		//------------------------------------------------------------------------
	
	   //if undo above comment remove this clsbracket
	private JButton getBtnFinish() {
		if (btnFinish == null) {
			btnFinish = new JButton("Finish");
			btnFinish.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					try {
//			            this.tempFile.deleteOnExit();
						tempFile.deleteOnExit();
			        } catch (Exception ex) {
			        }
			        dispose();
				}
			});
			btnFinish.setBounds(42, 459, 143, 23);
		}
		return btnFinish;
	}
	private JLabel getLabel1() {
		if (label1 == null) {
			label1 = new JLabel("File not chosen");
			label1.setBounds(240, 71, 420, 14);
		}
		return label1;
	}
	private JLabel getLabelout() {
		if (labelout == null) {
			labelout = new JLabel("Output Location");
			labelout.setBounds(240, 414, 420, 14);
		}
		return labelout;
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			passwordField.setBounds(42, 357, 143, 23);
		}
		return passwordField;
	}
	private JLabel getLblPasswordToEncrypt() {
		if (lblPasswordToEncrypt == null) {
			lblPasswordToEncrypt = new JLabel("Password to Encrypt");
			lblPasswordToEncrypt.setBounds(240, 361, 143, 14);
		}
		return lblPasswordToEncrypt;
	}
	private JRadioButton getRdbtnTextFile() {
		if (rdbtnTextFile == null) {
			rdbtnTextFile = new JRadioButton("Text File to Hide");
			buttonGroup.add(rdbtnTextFile);
			rdbtnTextFile.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txtArea.setEnabled(false);
				        rdbtnTextFile.setEnabled(true);
				        btnText.setEnabled(true);
				}
			});
			rdbtnTextFile.setBounds(38, 161, 147, 23);
		}
		return rdbtnTextFile;
	}
	private JRadioButton getRdbtnWriteText() {
		if (rdbtnWriteText == null) {
			rdbtnWriteText = new JRadioButton("Write Text to Hide");
			buttonGroup.add(rdbtnWriteText);
			rdbtnWriteText.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					btnText.setEnabled(false);
				}
			});
			rdbtnWriteText.setSelected(true); 
			rdbtnWriteText.setBounds(42, 245, 143, 23);
		}
		return rdbtnWriteText;
	}
	private JTextArea getTxtArea() {
		if (txtArea == null) {
			txtArea = new JTextArea();
			txtArea.setText("write text here");
			
			txtArea.setBounds(240, 244, 420, 85);
		}
		return txtArea;
	}
	private JButton getBtnGoBack() {
		if (btnGoBack == null) {
			btnGoBack = new JButton("Go Back");
			btnGoBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
					
					
				}
			});
			btnGoBack.setBounds(241, 459, 124, 23);
		}
		return btnGoBack;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Hide your Text in Audio File");
			lblNewLabel.setForeground(new Color(0, 51, 153));
			lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
			lblNewLabel.setBounds(42, 21, 356, 23);
		}
		return lblNewLabel;
	}
	private JButton getBtnPlayAudio() {
		if (btnPlayAudio == null) {
			btnPlayAudio = new JButton("Play Audio");
			btnPlayAudio.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnPlayAudio.setBounds(41, 118, 89, 23);
		}
		return btnPlayAudio;
	}
	private JButton getBtnStopAudio() {
		if (btnStopAudio == null) {
			btnStopAudio = new JButton("Stop Audio");
			btnStopAudio.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnStopAudio.setBounds(149, 118, 89, 23);
		}
		return btnStopAudio;
	}
}
