package org.pdmsys.screen.screens;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import org.pdmsys.screen.constants.Constants;

/**
 * @author Dipankar
 *
 */
public class MainScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -350810197750222920L;

	JMenuBar menuBar;
	JLabel label;
	JMenu start;
	JMenu end;
	JMenuItem process;
	JMenuItem exit;
	SetLocation setLocation;
	
	private static MainScreen mainScreen = new MainScreen( );

	private MainScreen() {
		initUI();
	}
	
	/* Static 'instance' method */
	public static MainScreen getInstance( ) {
		return mainScreen;
	}

	public final void initUI() {
		menuBar = new JMenuBar();
		menuBar.setOpaque(true);
		menuBar.setPreferredSize(new Dimension(200, 20));

		label = new JLabel();
		label.setOpaque(true);
		label.setPreferredSize(new Dimension(200, 180));

		start = new JMenu("Start");
		start.setMnemonic(KeyEvent.VK_S);

		process = new JMenuItem("Process");
		process.setMnemonic(KeyEvent.VK_P);

		end = new JMenu("End");
		end.setMnemonic(KeyEvent.VK_D);

		exit = new JMenuItem("Exit");
		exit.setMnemonic(KeyEvent.VK_E);

		setJMenuBar(menuBar);
		add(label, BorderLayout.CENTER);

		// adding menu item to menu
		start.add(process);
		end.add(exit);

		// adding menus to menubar
		menuBar.add(start);
		menuBar.add(end);

		setVisible(true);
		setSize(900, 700);
		setTitle(Constants.APP_TITLE);
		setJMenuBar(menuBar);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		exit.setToolTipText(Constants.EXIT_APP);
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				Runtime.getRuntime().exit(0);
			}
			
		});

		process.setToolTipText(Constants.START_CAPTURING);
		process.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				setLocation = new SetLocation();
				setContentPane(setLocation);
				setTitle(Constants.APP_TITLE);
				revalidate();
				repaint();
			}
			
		});

		start.setToolTipText(Constants.START);
		end.setToolTipText(Constants.END);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

	}

}