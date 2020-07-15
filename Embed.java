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
	    public static int embedJIFNo = 1;
	    private int pEmbedJIFNo;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 413);
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
		
		//------
		setLocation(Front.embedJIFX, Front.embedJIFY);
        Front.embedJIFX += 20;
        Front.embedJIFY += 25;
        this.pEmbedJIFNo = embedJIFNo;
        embedJIFNo += 1;
		//-------
	}

	private JButton getBtnInput() {
		if (btnInput == null) {
			btnInput = new JButton("Input Audio");
			btnInput.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					Embed.this.btnInputActionPerformed(evt);
//					back= new BackEndHandler(this, BackEndHandler.EMBED_MESSAGE);
//					back.start();
				}
			});
			btnInput.setBounds(42, 24, 118, 23);
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
        //this.playButton.setEnabled(true);
    }
	
	//------------------------------------------------------------------------------------------------

	private JButton getBtnText() {
		if (btnText == null) {
			btnText = new JButton("Text File");
			btnText.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					Embed.this.btnTextActionPerformed(evt);
				}
			});
			btnText.setBounds(42, 100, 118, 23);
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
			label.setBounds(196, 104, 228, 14);
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
			this.btnOutput.setBounds(42, 292, 118, 23);
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
                    this.tempFile = File.createTempFile("AudioSteganographypyTemp" + this.pEmbedJIFNo, ".txt");
                } catch (IOException ex) {
                    //Logger.getLogger(Embed.class.getName()).log(Level.SEVERE, null, ex);
                }
                BufferedWriter output = null;
                try {//-------------------------------------------------
                    output = new BufferedWriter(new FileWriter(this.tempFile));
                    output.write(this.inputTextAreaString);
                    output.close();
                    //---------------------------------------------------------------
                } catch (IOException ex) {
                    //Logger.getLogger(Embed.class.getName()).log(Level.SEVERE, null, ex);
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
            JOptionPane.showMessageDialog(this, "1. Select Audio File\n2. Write Text or Select Text File\n3. Enter Password.", "Opps ! Something is missing !", 0);
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
			btnFinish.setBounds(42, 340, 118, 23);
		}
		return btnFinish;
	}
	private JLabel getLabel1() {
		if (label1 == null) {
			label1 = new JLabel("File not chosen");
			label1.setBounds(196, 28, 228, 14);
		}
		return label1;
	}
	private JLabel getLabelout() {
		if (labelout == null) {
			labelout = new JLabel("Output Location");
			labelout.setBounds(208, 296, 216, 14);
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
			passwordField.setBounds(42, 245, 118, 23);
		}
		return passwordField;
	}
	private JLabel getLblPasswordToEncrypt() {
		if (lblPasswordToEncrypt == null) {
			lblPasswordToEncrypt = new JLabel("Password to Encrypt");
			lblPasswordToEncrypt.setBounds(197, 249, 143, 14);
		}
		return lblPasswordToEncrypt;
	}
	private JRadioButton getRdbtnTextFile() {
		if (rdbtnTextFile == null) {
			rdbtnTextFile = new JRadioButton("Text File");
			buttonGroup.add(rdbtnTextFile);
			rdbtnTextFile.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txtArea.setEnabled(false);
				        rdbtnTextFile.setEnabled(true);
				        btnText.setEnabled(true);
				}
			});
			rdbtnTextFile.setBounds(38, 70, 109, 23);
		}
		return rdbtnTextFile;
	}
	private JRadioButton getRdbtnWriteText() {
		if (rdbtnWriteText == null) {
			rdbtnWriteText = new JRadioButton("Write Text");
			buttonGroup.add(rdbtnWriteText);
			rdbtnWriteText.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					btnText.setEnabled(false);
				}
			});
			rdbtnWriteText.setSelected(true); 
			rdbtnWriteText.setBounds(42, 142, 109, 23);
		}
		return rdbtnWriteText;
	}
	private JTextArea getTxtArea() {
		if (txtArea == null) {
			txtArea = new JTextArea();
			txtArea.setText("write text here");
			
			txtArea.setBounds(178, 141, 279, 85);
		}
		return txtArea;
	}
}
