package org.pdmsys.screen.splash;

import org.pdmsys.screen.constants.Constants;
import org.pdmsys.screen.screens.MainScreen;

/**
 * @author Dipankar
 *
 */
public final class SplashLauncher {
	
	private static SplashScreen fSplashScreen;
	private static final String SPLASH_IMAGE = Constants.SPLASH_IMAGE;
	
	public static void showSplashScreen() {
		fSplashScreen = new SplashScreen(SPLASH_IMAGE);
		fSplashScreen.splash();
	}
	
	public static void showMainWindow() {
		//new MainScreen();
		MainScreen.getInstance();
	}
	
	public static final class SplashScreenCloser implements Runnable {
		
		@Override
		public void run() {
			fSplashScreen.dispose();
		}
		
	}
	
}