package org.pdmsys.screen.screens;

import org.pdmsys.screen.constants.Constants;

/**
 * @author Dipankar
 *
 */
public class NavigationLogic {
	
	MainScreen mainScreen;
	SetLocation setLocation;
	CaptureScreen captureScreen;
	
	public void setLocationToCaptureScreen() {
		//mainScreen = new MainScreen();
		mainScreen = MainScreen.getInstance();
		setLocation = new SetLocation();
		captureScreen = new CaptureScreen();
		
		mainScreen.remove(setLocation);
		mainScreen.add(captureScreen);
		mainScreen.setTitle(Constants.APP_TITLE);
	}
	
	/*public void addBeanScreenToAddDependencyScreen() {
		
		mainScreen = new MainScreen();
		addBeanScreen = new AddBeanScreen();
		addDependencyScreen = new AddDependencyScreen();
		
		mainScreen.remove(addBeanScreen);
		mainScreen.add(addDependencyScreen);
		mainScreen.setTitle(Constants.title);
		
	}*/
	
}