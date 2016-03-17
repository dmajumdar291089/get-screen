package org.pdmsys.screen.screens;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;

import org.pdmsys.screen.constants.Constants;

/**
 * @author dipankar
 *
 */
public class NavigationAndLogic {
	
	private MainScreen mainScreen;
	private SetLocation setLocation;
	private CaptureScreen captureScreen;
	private String saveFolder;
	private Robot robot;
	
	public void setLocationToCaptureScreen() {
		mainScreen = MainScreen.getInstance();
		
		setLocation = SetLocation.getInstance();
		captureScreen = CaptureScreen.getInstance();
		
		saveFolder = setLocation.getSaveFolder();
		if(null != saveFolder && saveFolder != "") {
			mainScreen.remove(setLocation);
			mainScreen.setContentPane(captureScreen);
			mainScreen.setSize(190, 120);
			mainScreen.revalidate();
			mainScreen.repaint();
		}
	}
	
	public void getScreenCapture() {
		try {
			Calendar cal = Calendar.getInstance();
			Date date = cal.getTime();
			long millis = date.getTime();
			
            robot = new Robot();
            
            setLocation = SetLocation.getInstance();
            saveFolder = setLocation.getSaveFolder();
            if(null != saveFolder && saveFolder != "") {
            	String fileName = Constants.SCREEN_SHOT + Constants.UNDERSCORE + millis + Constants.DOT + Constants.IMAGE_EXTN_JPG;
            	
            	Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            	BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
            	ImageIO.write(screenFullImage, Constants.IMAGE_EXTN_JPG, new File(saveFolder + File.separator + fileName));
            }
		} catch (AWTException | IOException e) {
        	System.out.println("Error!!! >>> " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
        	System.out.println("Error!!! >>> " + e.getMessage());
            e.printStackTrace();
		}
	}
	
}