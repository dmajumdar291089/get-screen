package org.pdmsys.screen.screens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import org.pdmsys.screen.constants.Constants;

/**
 * @author dipankar
 *
 */
public class CaptureScreen extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3167588178292189408L;
	
	private JButton capture;
	private JPanel capturePanel;
	private NavigationAndLogic navigationLogic;
	private ImageIcon captureIcon;
	
	private static CaptureScreen captureScreen = new CaptureScreen();
	
	private CaptureScreen() {
		initUI();
	}
	
	/* Static 'instance' method */
	public static CaptureScreen getInstance() {
		return captureScreen;
	}
	
	public final void initUI() {
		
		captureIcon = new ImageIcon("images/submit.png");		
		capture = new JButton(Constants.CAPTURE,captureIcon);
		capture.setHorizontalTextPosition(AbstractButton.LEADING);
		
		capturePanel = new JPanel();
		capturePanel.add(capture);
		add(capturePanel);
		
		setVisible(true);
		repaint();
		
		capture.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				navigationLogic = new NavigationAndLogic();
				navigationLogic.getScreenCapture();
			}
			
		});
		
	}
	
}