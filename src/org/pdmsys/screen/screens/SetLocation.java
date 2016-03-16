package org.pdmsys.screen.screens;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.pdmsys.screen.constants.Constants;

/**
 * @author Dipankar
 *
 */
public class SetLocation extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4632162374126892560L;
	
	JLabel lbl_file_location, lbl_databaseName, lbl_MTD_field_dto_field_type, lbl_databaseIP, lbl_db_username, lbl_db_password, lbl_multitable, lbl_primaryField, lbl_retainPrimaryFieldInMultipletables;
	JTextField file_location, databaseName, MTD_field_dto_field_type, databaseIP, db_username, db_password;
	JComboBox<String> multitable, primaryField, retainPrimaryFieldInMultipletables;
	JButton btnAddBean, btnAddDependency, btnFileLocation;
	JPanel p1, p2, p3, p4, p5;
	GridLayout gl21, gl03;
	NavigationLogic navigationLogic;
	ImageIcon addBeanIcon, addDependencyIcon;
	JFileChooser filelocation;
	
	public SetLocation() {
		
		initUI();
		
	}
	
	public final void initUI() {
		
		lbl_file_location = new JLabel(Constants.FILE_LOCATION + " :");
		lbl_databaseName = new JLabel(Constants.DATABASE_NAME + " :");
		lbl_MTD_field_dto_field_type = new JLabel(Constants.CREATE_MTD_FIELD_DTO_FIELD_TYPE);
		lbl_databaseIP = new JLabel(Constants.DATABASE_IP);
		lbl_db_username = new JLabel(Constants.DB_USERNAME);
		lbl_db_password = new JLabel(Constants.DB_PASSWORD);
		lbl_multitable = new JLabel(Constants.MULTITABLE);
		lbl_primaryField = new JLabel(Constants.PRIMARY_FIELD);
		lbl_retainPrimaryFieldInMultipletables = new JLabel(Constants.RETAIN_PRIMARY_FIELD_IN_MULTITABLES);
	    
		file_location = new JTextField(20);
		databaseName = new JTextField(Constants.CREATE_MTD_JTEXTFIELD_SIZE);
		MTD_field_dto_field_type = new JTextField(Constants.CREATE_MTD_JTEXTFIELD_SIZE);
		databaseIP = new JTextField(Constants.CREATE_MTD_JTEXTFIELD_SIZE);
		db_username = new JTextField(Constants.CREATE_MTD_JTEXTFIELD_SIZE);
		db_password = new JTextField(Constants.CREATE_MTD_JTEXTFIELD_SIZE);
		
		filelocation = new JFileChooser();
		filelocation.setPreferredSize(new Dimension(40, 50));
		
		multitable = new JComboBox<String>();
		primaryField = new JComboBox<String>();
		retainPrimaryFieldInMultipletables = new JComboBox<String>();
		
		/* Logic for adding dependency_bean_name to combo-box must be written below */
		multitable.addItem(Constants.DROP_DOWN_SELECT);
		multitable.addItem(Constants.truevalue);
		multitable.addItem(Constants.falsevalue);
		/* */
		
		/* Logic for adding mtd_field_column_name_dependency to combo-box must be written below */
		primaryField.addItem(Constants.DROP_DOWN_SELECT);
		
		/* */
		
		/* Logic for adding mtd_field_column_name_dependency to combo-box must be written below */
		retainPrimaryFieldInMultipletables.addItem(Constants.DROP_DOWN_SELECT);
		retainPrimaryFieldInMultipletables.addItem(Constants.truevalue);
		retainPrimaryFieldInMultipletables.addItem(Constants.falsevalue);
		
		/* */
		
		addBeanIcon = new ImageIcon("images/forward.png");
		addDependencyIcon = new ImageIcon("images/forward.png");
		
		btnAddBean = new JButton(Constants.ADD_BEAN, addBeanIcon);
		btnAddBean.setHorizontalTextPosition(AbstractButton.LEADING);
		btnAddBean.setPreferredSize(new Dimension(200,50));
		
		btnAddDependency = new JButton(Constants.ADD_DEPENDENCY, addDependencyIcon);
		btnAddDependency.setHorizontalTextPosition(AbstractButton.LEADING);
		btnAddDependency.setPreferredSize(new Dimension(200,50));
		
		btnFileLocation = new JButton("Choose");
		btnFileLocation.setPreferredSize(new Dimension(20,20));
		btnFileLocation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser filechooser=new JFileChooser();
		       
		        filechooser.setApproveButtonText("Browse");
		        int value=filechooser.showOpenDialog(null);
		        if (value == JFileChooser.APPROVE_OPTION) {
		          try {
		            file_location.setText(filechooser.getSelectedFile().getCanonicalPath());
		          }
		          catch (IOException e) {
		            file_location.setText(filechooser.getSelectedFile().getAbsolutePath());
		          }
		        }	
				
			}
		});
		
		
		
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p3.add(Box.createVerticalStrut(80));
		
		p4 = new JPanel();
		p5 = new JPanel();
		
		gl21 = new GridLayout(Constants.GRID_LAYOUT_SIZE_0, Constants.GRID_LAYOUT_SIZE_2);
		
		p4.setLayout(gl21);
		p5.setLayout(gl21);
		p5.add(file_location);
		p5.add(btnFileLocation);
		p1.setLayout(gl21);
		
		//p1.add(lbl_file_location);
		//p1.add(btnFileLocation);
		p4.add(lbl_file_location);
		p4.add(p5);
		//p4.add(btnFileLocation);
		p1.add(lbl_databaseName);
		p1.add(databaseName);
		p1.add(lbl_MTD_field_dto_field_type);
		p1.add(MTD_field_dto_field_type);
		p1.add(lbl_databaseIP);
		p1.add(databaseIP);
		p1.add(lbl_db_username);
		p1.add(db_username);
		p1.add(lbl_db_password);
		p1.add(db_password);
		p1.add(lbl_multitable);
		p1.add(multitable);
		p1.add(lbl_primaryField);
		p1.add(primaryField);
		p1.add(lbl_retainPrimaryFieldInMultipletables);
		p1.add(retainPrimaryFieldInMultipletables);
		
		add(p3);
		add(p4);
		add(p1);
		
		p2.add(btnAddBean);
		p2.add(btnAddDependency);
		add(p2);
		
		setVisible(true);
		repaint();
		
		btnAddBean.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				navigationLogic = new NavigationLogic();
				navigationLogic.setLocationToCaptureScreen();
			}
			
		});
		
	}
	
}