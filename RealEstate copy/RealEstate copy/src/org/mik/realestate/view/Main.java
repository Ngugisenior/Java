package org.mik.realestate.view;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

public class Main {

	public final static int MAIN_WIDTH=800;
	public final static int MAIN_HEIGHT=600;
	
	protected JFrame mainFrame;
	private RealEstateController realEstateController;
	
	public Main() {
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				try {
					new Main().init();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	protected void init() {
		this.realEstateController = new RealEstateController();
		createGUI();
	}
	
	protected void createGUI() {
		this.mainFrame = new JFrame("Real Estate Demo"); //$NON-NLS-1$
		this.mainFrame.setSize(MAIN_WIDTH, MAIN_HEIGHT);
		this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.mainFrame.setJMenuBar(createMenubar());		
		this.mainFrame.setVisible(true);
	}
	
	protected void openRealEstateForm() {
		this.realEstateController.getRealEstateWindow().setVisible(true);
	}
	
	private JMenuBar createMenubar() {
		JMenuBar menubar = new JMenuBar();
		JMenu file=new JMenu("File"); //$NON-NLS-1$
		JMenuItem realEstate = new JMenuItem("Real Estates"); //$NON-NLS-1$
		JMenuItem exit=new JMenuItem("Exit"); //$NON-NLS-1$
		realEstate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				openRealEstateForm();
				
			}
		});
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				realEstateController.shutdown();
				WindowEvent wev = new WindowEvent(Main.this.mainFrame, WindowEvent.WINDOW_CLOSING);
				Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
				Main.this.mainFrame.dispatchEvent(wev);
				Main.this.mainFrame.setVisible(false);
				Main.this.mainFrame.dispose();
				System.exit(0);
			}
		});
		file.add(realEstate);
		file.addSeparator();
		file.add(exit);
		menubar.add(file);
		return menubar;
	}
	
}
