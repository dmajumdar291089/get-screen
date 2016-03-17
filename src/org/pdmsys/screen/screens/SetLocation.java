package org.pdmsys.screen.screens;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.pdmsys.screen.constants.Constants;

/**
 * @author dipankar
 *
 */
public class SetLocation extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8179016335738335192L;
	
	private JTextField file_location;
	private JButton btnNext, btnFileLocation;
	private JPanel panelNext, panelLocation, panelSetLocation;
	private GridLayout grid01, grid02;
	private NavigationAndLogic navigationLogic;
	private ImageIcon nextIcon;
	private JFileChooser filelocation;
	private String saveFolder;
	
	private static SetLocation setLocation = new SetLocation();
	
	private SetLocation() {
		initUI();
	}
	
	/* Static 'instance' method */
	public static SetLocation getInstance() {
		return setLocation;
	}
	
	public final void initUI() {
	    
		file_location = new JTextField(20);
		file_location.setEditable(false);
		
		filelocation = new JFileChooser();
		filelocation.setPreferredSize(new Dimension(40, 50));
		
		nextIcon = new ImageIcon("images/forward.png");
		
		btnNext = new JButton(Constants.NEXT, nextIcon);
		btnNext.setHorizontalTextPosition(AbstractButton.LEADING);
		btnNext.setPreferredSize(new Dimension(200,50));
		
		btnFileLocation = new JButton(Constants.CHOOSE_LOCATION);
		btnFileLocation.setPreferredSize(new Dimension(20,20));
		
		btnFileLocation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser filechooser=new JFileChooser();
				filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				
		        filechooser.setApproveButtonText("Browse");
		        int value=filechooser.showOpenDialog(null);
		        if (value == JFileChooser.APPROVE_OPTION) {
		          try {
		            file_location.setText(filechooser.getSelectedFile().getCanonicalPath());
		            if(null != file_location.getText() && file_location.getText() != "") {
		            	saveFolder = file_location.getText();
		            }
		          }
		          catch (IOException e) {
		            file_location.setText(filechooser.getSelectedFile().getAbsolutePath());
		            if(null != file_location.getText() && file_location.getText() != "") {
		            	saveFolder = file_location.getText();
		            }
		          }
		        }	
				
			}
		});
		
		panelNext = new JPanel();
		
		panelLocation = new JPanel();
		panelSetLocation = new JPanel();
		
		grid01 = new GridLayout(Constants.GRID_LAYOUT_SIZE_0, Constants.GRID_LAYOUT_SIZE_1);
		grid02 = new GridLayout(Constants.GRID_LAYOUT_SIZE_0, Constants.GRID_LAYOUT_SIZE_2);
		
		panelLocation.setLayout(grid01);
		panelSetLocation.setLayout(grid02);
		panelSetLocation.add(file_location);
		panelSetLocation.add(btnFileLocation);
		
		panelLocation.add(panelSetLocation);
		
		panelNext.add(btnNext);
		
		panelLocation.add(panelNext);
		add(panelLocation);
		
		setVisible(true);
		repaint();
		
		btnNext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				navigationLogic = new NavigationAndLogic();
				navigationLogic.setLocationToCaptureScreen();
			}
			
		});
		
	}

	/**
	 * @return the saveFolder
	 */
	public String getSaveFolder() {
		return saveFolder;
	}
	
}