package org.mik.realestate.view;

import java.util.List;

import org.mik.realestate.dao.RealEstateDao;
import org.mik.realestate.domain.RealEstate;

/**
 * Controller for MVC design pattern 
 * 
 * @author zamek
 *
 */
public class RealEstateController {
	
	/**
	 * DAO
	 */
	private RealEstateDao realEstateDao;
	/**
	 * Form
	 */
	private RealEstateWindow realEstateWindow;
	
	/**
	 * Current computer 
	 */
	private RealEstate currentRealEstate;

	/**
	 * All computer list 
	 */
	private List<RealEstate> all;

	/**
	 * Constructor
	 */
	public RealEstateController () {
		this.realEstateDao = RealEstateDao.createRealEstateDao();
		this.realEstateWindow = new RealEstateWindow(this);
		first();
	}

	/**
	 * Getter for Computerindow
	 * 
	 * @return ComputerWindow
	 */
	public RealEstateWindow getRealEstateWindow() {
		return this.realEstateWindow;
	}
	
	/**
	 * Load all computer list and select first element as current comuter if the list is not empty
	 */
	public void first() {
		this.setCurrent(null);
		this.all=this.realEstateDao.listOrderById();
		if (this.all.size()>0)
			setCurrent(this.all.get(0));
		updateGUI();
	}
	
	/**
	 * Select previous computer in the list, if the list is not empty and the current computer is not the first element in the list.
	 */
	public void prev() {
		if (this.currentRealEstate !=null && this.all.indexOf(this.currentRealEstate)>0) 
			setCurrent(this.all.get(this.all.indexOf(this.currentRealEstate)-1));
		
		updateGUI();
	}
	
	/**
	 * Select next computer in the list if the list is not empty and the current computer is not the last element in the list.
	 */
	public void next() {
		if (this.currentRealEstate!=null && this.all.indexOf(this.currentRealEstate)<this.all.size()-1) {
			setCurrent(this.all.get(this.all.indexOf(this.currentRealEstate)+1));
		}
		updateGUI();
	}
	
	/**
	 * Create a new Computer and set it to current 
	 */
	public void insert() {
		setCurrent(this.realEstateWindow.getRealEstatePanel().getData());
		RealEstate realEstate = new RealEstate();
		
		realEstate.setType(this.currentRealEstate.getType());
		realEstate.setPrice(this.currentRealEstate.getPrice());
		realEstate.setAddress(this.currentRealEstate.getAddress());
		realEstate.setAge(this.currentRealEstate.getAge());
		realEstate.setSize(this.currentRealEstate.getSize());
		
		@SuppressWarnings("unused")
		RealEstate realEstate2 = this.realEstateDao.insert(realEstate);
		updateGUI();
	}
	
	/**
	 * update current computer data to database
	 */
	public void update() {
		setCurrent(this.realEstateWindow.getRealEstatePanel().getData());
		if (this.currentRealEstate.getId()==null) 
			setCurrent(this.realEstateDao.insert(this.currentRealEstate));
		else
			this.realEstateDao.update(this.currentRealEstate);
		Integer id = this.currentRealEstate.getId();
		first();
		for(RealEstate c:this.all) 
			if (c.getId().equals(id)) {
				setCurrent(c);
				updateGUI();
				break;
			}
	}
	
	/**
	 * Delete the current computer from database
	 */
	public void delete() {
		try {
			this.realEstateDao.delete(this.currentRealEstate);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		first();
	}
	
	/**
	 * Close the computer window
	 */
	public void close() {
		this.realEstateWindow.setVisible(false);
	}
	
	public void shutdown() {
		this.realEstateDao.shutdown();
	}
	
	/**
	 * Upate GUI
	 * 
	 * Set the state of buttons
	 * There some bug in this code, you can fix it
	 */
	private void updateGUI() {
		this.realEstateWindow.btnInsert.setEnabled(this.currentRealEstate != null);
		this.realEstateWindow.btnInsert.setEnabled(true);
		this.realEstateWindow.btnDelete.setEnabled(this.currentRealEstate!=null);
		this.realEstateWindow.btnUpdate.setEnabled(this.currentRealEstate!=null);
		int idx = this.all.indexOf(this.currentRealEstate);
		this.realEstateWindow.btnPrev.setEnabled(!this.all.isEmpty() && idx>0);
		this.realEstateWindow.btnNext.setEnabled(!this.all.isEmpty() && idx<this.all.size()-1);
	}
	
	/**
	 * Set the current computer
	 * 
	 * @param c the current computer
	 */
	private void setCurrent(RealEstate r) {
		this.currentRealEstate = r;
		this.realEstateWindow.getRealEstatePanel().setData(r);
	}
}

