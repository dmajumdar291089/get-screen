package org.pdmsys.screen.splash;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.image.ImageObserver;
import java.net.URL;

/**
 * @author Dipankar
 *
 */
final class SplashScreen extends Frame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5925189027400299717L;
	
	private final String fImageId;
	private MediaTracker fMediaTracker;
	private Image fImage;
	private static final ImageObserver NO_OBSERVER = null;
	private static final int IMAGE_ID = 0;
	
	SplashScreen(String aImageId) {
		if (aImageId == null || aImageId.trim().length() == 0) {
			throw new IllegalArgumentException("Image Id does not have content.");
		}
		fImageId = aImageId;
	}
	
	void splash() {
		initImageAndTracker();
		setSize(fImage.getWidth(NO_OBSERVER), fImage.getHeight(NO_OBSERVER));
		center();
		fMediaTracker.addImage(fImage, IMAGE_ID);
		
		try {
			fMediaTracker.waitForID(IMAGE_ID);
		} catch (InterruptedException e) {
			System.out.println("Cannot track image load.");
			System.out.println("InterruptedException!!! >>> " + e.getMessage());
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("Exception!!! >>> " + e.getMessage());
		    e.printStackTrace();
		}
		
		new SplashWindow(this, fImage);
	}
	
	private void initImageAndTracker() {
		fMediaTracker = new MediaTracker(this);
		URL imageURL = SplashScreen.class.getResource(fImageId);
		fImage = Toolkit.getDefaultToolkit().getImage(imageURL);
	}
	
	private void center() {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle frame = getBounds();
		setLocation((screen.width - frame.width) / 2, (screen.height - frame.height) / 2);
	}
	
	private final class SplashWindow extends Window {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 892125360759846297L;
		
		private Image fImage;
		
		SplashWindow(Frame aParent, Image aImage) {
			super(aParent);
			fImage = aImage;
			setSize(fImage.getWidth(NO_OBSERVER), fImage.getHeight(NO_OBSERVER));
			Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle window = getBounds();
			setLocation((screen.width - window.width) / 2, (screen.height - window.height) / 2);
			setVisible(true);
		}
		
		@Override
		public void paint(Graphics graphics) {
			if (fImage != null) {
				graphics.drawImage(fImage, 0, 0, this);
			}
		}
		
	}

}