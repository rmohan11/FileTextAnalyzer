import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JRadioButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class FirstWindowBuilder extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private File file1;

	/**
	 * Launch the application.
	 */
	public static void FWB() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstWindowBuilder frame = new FirstWindowBuilder();
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
	public FirstWindowBuilder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 353);
		setTitle("Text Analyzer");
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		/*
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem jm11 = new JMenuItem("Add a File");
		JMenuItem jm12 = new JMenuItem("Analyze a File");
		JMenuItem jm13 = new JMenuItem("Remove a File");
		mnFile.add(jm11);
		mnFile.add(jm12);
		mnFile.add(jm13);
		
		JMenu mnNewMenu = new JMenu("View");
		menuBar.add(mnNewMenu);
		JMenuItem jm21 = new JMenuItem("View File content");
		mnNewMenu.add(jm21);
		*/
		JMenu mnNewMenu_1 = new JMenu("Help");
		menuBar.add(mnNewMenu_1);
		JMenuItem jm31 = new JMenuItem("User Manual");
		jm31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HelpOutput.method1();
			}
		});
		mnNewMenu_1.add(jm31);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{95, 47, 232, 45, 0};
		gbl_contentPane.rowHeights = new int[]{95, 23, 23, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton btnNewButton = new JButton("...");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FileNameExtensionFilter filter = new FileNameExtensionFilter("doc", "docx", "txt", "java", "c", "cpp", "h", "pl");
				JFileChooser jfc1 = new JFileChooser();
				jfc1.setFileFilter(filter);
				int rval1 = jfc1.showOpenDialog(null);
				if(rval1 == JFileChooser.APPROVE_OPTION) {
					file1 = jfc1.getSelectedFile();
					textField_1.setText(file1.getName());
				}
			}
		});
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Text");
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.anchor = GridBagConstraints.NORTHWEST;
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton.gridx = 1;
		gbc_rdbtnNewRadioButton.gridy = 1;
		contentPane.add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
		
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setEnabled(false);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("File");
		GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_1.gridx = 1;
		gbc_rdbtnNewRadioButton_1.gridy = 2;
		contentPane.add(rdbtnNewRadioButton_1, gbc_rdbtnNewRadioButton_1);
		
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 2;
		contentPane.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		btnNewButton.setEnabled(false);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 2;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		ButtonGroup bg = new ButtonGroup();
		
		ActionListener al1 = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textField.setEnabled(rdbtnNewRadioButton.isSelected());
				textField.setEditable(rdbtnNewRadioButton.isSelected());
				textField_1.setEnabled(!rdbtnNewRadioButton.isSelected());
				btnNewButton.setEnabled(!rdbtnNewRadioButton.isSelected());
				if(rdbtnNewRadioButton.isSelected()) {
					textField.requestFocusInWindow();
				}
			}
		};
		bg.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.addActionListener(al1);
		bg.add(rdbtnNewRadioButton_1);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.WEST;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.VERTICAL;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 3;
		contentPane.add(panel, gbc_panel);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					readTheFileOrText();
				} 
				catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			@SuppressWarnings("unused")
			private void readTheFileOrText() throws IOException {
				// TODO Auto-generated method stub
				if(rdbtnNewRadioButton.isSelected()) {
					String s1 = new String(textField.getText());
					if(s1.length() > 0)
						{
							Stats_File_Analyzer t1 = new Stats_File_Analyzer(s1, 1);
						}
				}
				else if(file1 != null) {
					String fp = file1.getPath();
					
					//String fn = file1.getName();
					Stats_File_Analyzer m1 = new Stats_File_Analyzer(fp);
				}
			}
		});
		panel.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		panel.add(btnCancel);
		rdbtnNewRadioButton_1.addActionListener(al1);
		
	}
}
