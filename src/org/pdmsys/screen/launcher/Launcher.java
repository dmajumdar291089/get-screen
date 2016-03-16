package org.pdmsys.screen.launcher;

import java.awt.EventQueue;

import org.pdmsys.screen.splash.SplashLauncher;
import org.pdmsys.screen.splash.SplashLauncher.SplashScreenCloser;

/**
 * @author Dipankar
 *
 */
public class Launcher {
	
	public static void main(String[] args) {
		SplashLauncher.showSplashScreen();
		
		try {
			Thread.sleep(3000);
		} catch(InterruptedException e) {
		    System.out.println("InterruptedException!!! >>> " + e.getMessage());
		    e.printStackTrace();
		} catch(Exception e) {
			System.out.println("Exception!!! >>> " + e.getMessage());
		    e.printStackTrace();
		}
		
		SplashLauncher.showMainWindow();
		EventQueue.invokeLater(new SplashScreenCloser());
	}
	
}