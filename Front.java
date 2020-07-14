package prototype;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.filechooser.*;



import javax.swing.JLabel;

public class Front {
	//------------
	public static int embedJIFX = 0;
    public static int embedJIFY = 0;
    public static int extractJIFX = 600;
    public static int extractJIFY = 0;
	//----

	private JFrame frame;
	private JButton btnExtract;
	private JButton btnEmbed;
	private JLabel l;
	private JLabel lblUnhideTextFrom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Front window = new Front();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getBtnExtract());
		frame.getContentPane().add(getBtnEmbed());
		frame.getContentPane().add(getL());
		frame.getContentPane().add(getLblUnhideTextFrom());
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
			btnExtract.setBounds(228, 86, 89, 23);
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
					
					
//					 JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
//					  
//			            // invoke the showsOpenDialog function to show the save dialog 
//			            int r = j.showOpenDialog(null); 
//			         // if the user selects a file 
//			            if (r == JFileChooser.APPROVE_OPTION) 
//			  
//			            { 
//			                // set the label to the path of the selected file 
//			                l.setText(j.getSelectedFile().getAbsolutePath()); 
//			            } 
//			            // if the user cancelled the operation 
//			            else
//			                l.setText("the user cancelled the operation"); 
      } 
			  
				
			});
			btnEmbed.setBounds(228, 22, 89, 23);
		}
		return btnEmbed;
	}
	private JLabel getL() {
		if (l == null) {
			l = new JLabel("Hide Text In Audio");
			l.setBounds(37, 26, 181, 14);
		}
		return l;
	}
	private JLabel getLblUnhideTextFrom() {
		if (lblUnhideTextFrom == null) {
			lblUnhideTextFrom = new JLabel("Unhide Text From Audio");
			lblUnhideTextFrom.setBounds(37, 90, 168, 14);
		}
		return lblUnhideTextFrom;
	}
}
