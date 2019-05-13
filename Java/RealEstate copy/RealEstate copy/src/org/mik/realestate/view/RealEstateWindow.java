package org.mik.realestate.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Computer form
 * 
 * You can make a better architecture for form handling
 * 
 * @author zamek
 *
 */
public class RealEstateWindow extends JFrame {

	/**
	 * Computer view
	 */
	private RealEstatePanel realEstateView;
	/**
	 * prev buton
	 */
	protected JButton btnPrev;
	/**
	 * insert button
	 */
	protected JButton btnInsert;
	/**
	 * update button
	 */
	protected JButton btnUpdate;
	/**
	 * delete button
	 */
	protected JButton btnDelete;
	/**
	 * next button
	 */
	protected JButton btnNext;
	/**
	 * close form button
	 */
	protected JButton btnClose;
	/**
	 * Controller
	 */
	protected RealEstateController controller;
	
	/**
	 * Constructor
	 * 
	 * @param controller
	 */
	public RealEstateWindow(RealEstateController controller) {
		super();
		setLayout(new BorderLayout());
		this.controller = controller;
		createGUI();
		pack();
	}

	/**
	 * getter for realestate view
	 * @return
	 */
	public RealEstatePanel getRealEstatePanel() {
		return this.realEstateView;
	}

	/**
	 * Getter for prev button
	 * @return
	 */
	public JButton getPrevButton() {
		return this.btnPrev;
	}
	
	/**
	 * Getter for insert button
	 * @return
	 */
	public JButton getInsertButton() {
		return this.btnInsert;
	}
	
	/**
	 * Getter for update button
	 * @return
	 */
	public JButton getUpdateButton() {
		return this.btnUpdate;
	}
	
	/**
	 * Getter for delete button
	 * @return
	 */
	public JButton getDeleteButton() {
		return this.btnDelete;
	}
	
	/**
	 * Getter for next button
	 * @return
	 */
	public JButton getNextButton() {
		return this.btnNext;
	}

	/**
	 * Create gui 
	 */
	private void createGUI() {
		this.realEstateView = new RealEstatePanel();
		add(this.realEstateView, BorderLayout.CENTER);
		add(createButtons(), BorderLayout.SOUTH);
	}
	
	/**
	 * Create buttons
	 * 
	 * @return
	 */
	private JPanel createButtons() {
		JPanel result = new JPanel();
		result.setLayout(new FlowLayout());
		this.btnPrev = new JButton("Prev"); //$NON-NLS-1$
		this.btnPrev.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RealEstateWindow.this.realEstateView.readInitialStatus();
				RealEstateWindow.this.controller.prev();
			}
		});
		result.add(this.btnPrev);
		
		this.btnInsert = new JButton("Insert"); //$NON-NLS-1$
		this.btnInsert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RealEstateWindow.this.realEstateView.readInitialStatus();
				RealEstateWindow.this.controller.insert();
			}
		});
		result.add(this.btnInsert);
		
		this.btnUpdate=new JButton("Update"); //$NON-NLS-1$
		this.btnUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RealEstateWindow.this.realEstateView.readInitialStatus();
				RealEstateWindow.this.controller.update();
			}
		});
		result.add(this.btnUpdate);
		
		this.btnDelete = new JButton("Delete"); //$NON-NLS-1$
		this.btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RealEstateWindow.this.realEstateView.readInitialStatus();
				RealEstateWindow.this.controller.delete();
			}
		});
		result.add(this.btnDelete);
		
		this.btnNext = new JButton("Next"); //$NON-NLS-1$
		this.btnNext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RealEstateWindow.this.realEstateView.readInitialStatus();
				RealEstateWindow.this.controller.next();
			}
		});
		result.add(this.btnNext);
		
		this.btnClose = new JButton("Close"); //$NON-NLS-1$
		this.btnClose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RealEstateWindow.this.realEstateView.readInitialStatus();
				RealEstateWindow.this.controller.close();
			}
		});
		result.add(this.btnClose);
		
		return result;
	}
}
