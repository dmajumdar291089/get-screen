package org.pdmsys.screen.screens;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.pdmsys.screen.constants.Constants;

public class CaptureScreen extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3426678884855469754L;
	
	JLabel lbl_mtd_field_name, lbl_mtd_field_column_name, lbl_mtd_field_dto_name, lbl_mtd_field_dto_field_name, lbl_mtd_field_parent_dto_name, lbl_mtd_field_parent_dto_field_name, lbl_mtd_field_dto_field_type, lbl_tablename;
	JTextField mtd_field_name, mtd_field_column_name, mtd_field_dto_name, mtd_field_dto_field_name, mtd_field_parent_dto_name, mtd_field_parent_dto_field_name, mtd_field_dto_field_type, tableName;
	JButton btnAddDependency, btnAddAnotherBean;
	JPanel p1, p2, p3;
	GridLayout gl21;
	NavigationLogic navigationLogic;
	ImageIcon addAnotherBeanIcon, addDependencyIcon;
	
	public CaptureScreen() {
		
		initUI();
		
	}
	
	public final void initUI() {
		
		lbl_mtd_field_name = new JLabel(Constants.MTD_FIELD_NAME + " :");
		lbl_mtd_field_column_name = new JLabel(Constants.MTD_FIELD_COLUMN_NAME + " :");
		lbl_mtd_field_dto_name = new JLabel(Constants.MTD_FIELD_DTO_NAME + " :");
		lbl_mtd_field_dto_field_name = new JLabel(Constants.MTD_FIELD_DTO_FIELD_NAME + " :");
		lbl_mtd_field_parent_dto_name = new JLabel(Constants.MTD_FIELD_PARENT_DTO_NAME + " :");
	    lbl_mtd_field_parent_dto_field_name = new JLabel(Constants.MTD_FIELD_PARENT_DTO_FIELD_NAME + " :");
	    lbl_mtd_field_dto_field_type = new JLabel(Constants.MTD_FIELD_DTO_FIELD_TYPE + " :");
	    lbl_tablename = new JLabel(Constants.TABLE_NAME + " :");
	    
		mtd_field_name = new JTextField(Constants.ADD_BEAN_JTEXTFIELD_SIZE);
		mtd_field_column_name = new JTextField(Constants.ADD_BEAN_JTEXTFIELD_SIZE);
		mtd_field_dto_name = new JTextField(Constants.ADD_BEAN_JTEXTFIELD_SIZE);
		mtd_field_dto_field_name = new JTextField(Constants.ADD_BEAN_JTEXTFIELD_SIZE);
		mtd_field_parent_dto_name = new JTextField(Constants.ADD_BEAN_JTEXTFIELD_SIZE);
		mtd_field_parent_dto_field_name = new JTextField(Constants.ADD_BEAN_JTEXTFIELD_SIZE);
		mtd_field_dto_field_type = new JTextField(Constants.ADD_BEAN_JTEXTFIELD_SIZE);
		tableName = new JTextField(Constants.ADD_BEAN_JTEXTFIELD_SIZE);
		
		addDependencyIcon = new ImageIcon("images/forward.png");		
		btnAddDependency = new JButton(Constants.ADD_DEPENDENCY,addDependencyIcon);
		btnAddDependency.setHorizontalTextPosition(AbstractButton.LEADING);
		btnAddDependency.setPreferredSize(new Dimension(200,50));
		
		addAnotherBeanIcon = new ImageIcon("images/forward.png");
		btnAddAnotherBean = new JButton(Constants.ADD_ANOTHER_BEAN,addAnotherBeanIcon);
		btnAddAnotherBean.setHorizontalTextPosition(AbstractButton.LEADING);
		btnAddAnotherBean.setPreferredSize(new Dimension(200,50));
		
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p3.add(Box.createVerticalStrut(80));
		
		gl21 = new GridLayout(Constants.GRID_LAYOUT_SIZE_0, Constants.GRID_LAYOUT_SIZE_2);
		
		p1.setLayout(gl21);
		p1.add(lbl_mtd_field_name);
		p1.add(mtd_field_name);
		p1.add(lbl_mtd_field_column_name);
		p1.add(mtd_field_column_name);
		p1.add(lbl_mtd_field_dto_name);
		p1.add(mtd_field_dto_name);
		p1.add(lbl_mtd_field_dto_field_name);
		p1.add(mtd_field_dto_field_name);
		p1.add(lbl_mtd_field_parent_dto_name);
		p1.add(mtd_field_parent_dto_name);
		p1.add(lbl_mtd_field_parent_dto_field_name);
		p1.add(mtd_field_parent_dto_field_name);
		p1.add(lbl_mtd_field_dto_field_type);
		p1.add(mtd_field_dto_field_type);
		p1.add(lbl_tablename);
		p1.add(tableName);
		add(p3);
		add(p1);
		
		p2.add(btnAddDependency);
		p2.add(btnAddAnotherBean);
		add(p2);
		
		setVisible(true);
		repaint();
		
		btnAddAnotherBean.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				
				
				//Clearing the text-fields for adding another bean
				mtd_field_name.setText("");
				mtd_field_column_name.setText("");
				mtd_field_dto_name.setText("");
				mtd_field_dto_field_name.setText("");
				mtd_field_parent_dto_name.setText("");
				mtd_field_parent_dto_field_name.setText("");
				mtd_field_dto_field_type.setText("");
				tableName.setText("");
				
			}
			
		});
		
		btnAddDependency.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				
				
				navigationLogic = new NavigationLogic();
				//navigationLogic.addBeanScreenToAddDependencyScreen();
				
			}
			
		});
		
	}
	
}