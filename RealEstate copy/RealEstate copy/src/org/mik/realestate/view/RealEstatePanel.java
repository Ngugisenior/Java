package org.mik.realestate.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.mik.realestate.domain.RealEstate;

/**
 * The domain form
 * 
 * @author zamek
 *
 */
public class RealEstatePanel extends JPanel {
	protected JTextField tfAddress;
	protected JComboBox<String> cbType;
	protected JSpinner spPrice;
	protected JSpinner spAge;
	protected JSpinner spSize;
	protected RealEstate realEstate;
	
	/**
	 * Create the panel.
	 */
	public RealEstatePanel() {
		super();
		createGUI();
		this.cbType.setModel(new DefaultComboBoxModel<>(RealEstate.TYPE_VALUES));
		
	}
	
	/**
	 * Create GUI 
	 */
	private void createGUI() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		
		/**
		 * Layout is GridbagLayout. 
		 */
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		
		//TODO If you need more rows, you can add a 0 to rowHeights array
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		//TODO name label
		JLabel lbAddress = new JLabel("Address"); //$NON-NLS-1$
		GridBagConstraints gbc_lbAddress = new GridBagConstraints();
		gbc_lbAddress.insets=new Insets(10, 5, 5, 5);
		gbc_lbAddress.anchor = GridBagConstraints.EAST;
		gbc_lbAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lbAddress.gridx = 0;							// column index
		gbc_lbAddress.gridy = 0;							// row index
		add(lbAddress, gbc_lbAddress);
		
		//TODO name textfield
		this.tfAddress = new JTextField();
		GridBagConstraints gbc_tfAddress = new GridBagConstraints();
		gbc_tfAddress.insets = new Insets(10, 0, 5, 5);
		gbc_tfAddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfAddress.gridx = 2;							// column index
		gbc_tfAddress.gridy = 0;							// row index
		add(this.tfAddress, gbc_tfAddress);
		this.tfAddress.setColumns(140);
		this.tfAddress.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if (RealEstatePanel.this.realEstate!=null) 
					RealEstatePanel.this.realEstate.setAddress(RealEstatePanel.this.tfAddress.getText());
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				//NC
			}
		});
				
		//TODO label for type
		JLabel lbType = new JLabel("Type"); //$NON-NLS-1$
		GridBagConstraints gbc_lbType = new GridBagConstraints();
		gbc_lbType.anchor = GridBagConstraints.EAST;
		gbc_lbType.insets = new Insets(0, 0, 5, 5);
		gbc_lbType.gridx = 0;						// column index
		gbc_lbType.gridy = 1;						// row index
		add(lbType, gbc_lbType);
		
		//TODO type combo box 
		this.cbType = new JComboBox<>();
		GridBagConstraints gbc_cbType = new GridBagConstraints();
		gbc_cbType.insets = new Insets(0, 0, 5, 5);
		gbc_cbType.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbType.gridx = 2;						// column index
		gbc_cbType.gridy = 1;						// row index
		this.cbType.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (RealEstatePanel.this.realEstate!=null)
					RealEstatePanel.this.realEstate.setType(RealEstatePanel.this.cbType.getSelectedIndex());
			}
		});
		add(this.cbType, gbc_cbType);
		
		//TODO label for price
		JLabel lbPrice = new JLabel("Price ($)"); //$NON-NLS-1$
		GridBagConstraints gbc_lbPrice = new GridBagConstraints();
		gbc_lbPrice.anchor = GridBagConstraints.EAST;
		gbc_lbPrice.insets = new Insets(0, 0, 5, 5);
		gbc_lbPrice.gridx = 0;						// column index
		gbc_lbPrice.gridy = 2;						// row index
		add(lbPrice, gbc_lbPrice);
		
		//TODO price spinner 
		this.spPrice = new JSpinner();
		// model for spinner first 0 is the current value, second 0 is the minimum value, 128 is the maximum value, 1 is the step
		this.spPrice.setModel(new SpinnerNumberModel(0, 0, 1000000000, 5000));		
		GridBagConstraints gbc_spPrice = new GridBagConstraints();
		gbc_spPrice.anchor = GridBagConstraints.WEST;
		gbc_spPrice.fill = GridBagConstraints.HORIZONTAL;
		gbc_spPrice.insets = new Insets(0, 0, 5, 5);
		gbc_spPrice.gridx = 2;						// column index
		gbc_spPrice.gridy = 2;						// row index
		this.spPrice.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				if (RealEstatePanel.this.realEstate!=null)
					RealEstatePanel.this.realEstate.setPrice(((Number)RealEstatePanel.this.spPrice.getValue()).intValue());
			}
		});
		add(this.spPrice, gbc_spPrice);
		
		//TODO age label
		JLabel lblAge = new JLabel("Age"); //$NON-NLS-1$
		GridBagConstraints gbc_lblAge = new GridBagConstraints();
		gbc_lblAge.anchor = GridBagConstraints.EAST;
		gbc_lblAge.insets = new Insets(0, 0, 5, 5);
		gbc_lblAge.gridx = 0;		//column index
		gbc_lblAge.gridy = 3;		//row index
		add(lblAge, gbc_lblAge);
		
		//TODO disk capacity spinner
		this.spAge = new JSpinner();
		// model for spinner first 0 is the current value, second 0 is the minimum value, 5000 is the maximum value, 1 is the step
		this.spAge.setModel(new SpinnerNumberModel(0, 0, 400, 1)); 
		GridBagConstraints gbc_spAge = new GridBagConstraints();
		gbc_spAge.fill = GridBagConstraints.HORIZONTAL;
		gbc_spAge.anchor = GridBagConstraints.WEST;
		gbc_spAge.insets = new Insets(0, 0, 5, 5);
		gbc_spAge.gridx = 2;						//column index
		gbc_spAge.gridy = 3;						//row index
		this.spAge.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				if (RealEstatePanel.this.realEstate!=null)
					RealEstatePanel.this.realEstate.setAge(((Number)RealEstatePanel.this.spAge.getValue()).intValue());
			}
		});
		add(this.spAge, gbc_spAge);
		
		//TODO Display type Size
		JLabel lblSize = new JLabel("Size(sqft)"); //$NON-NLS-1$
		GridBagConstraints gbc_lblSize = new GridBagConstraints();
		gbc_lblSize.anchor = GridBagConstraints.EAST;
		gbc_lblSize.insets = new Insets(0, 0, 5, 5);
		gbc_lblSize.gridx = 0;		//column index
		gbc_lblSize.gridy = 4;		//row index
		add(lblSize, gbc_lblSize);
		
		//TODO size spinner
				this.spSize = new JSpinner();
				// model for spinner first 0 is the current value, second 0 is the minimum value, 5000 is the maximum value, 1 is the step
				this.spSize.setModel(new SpinnerNumberModel(0, 0, 50000, 50)); 
				GridBagConstraints gbc_spSize = new GridBagConstraints();
				gbc_spSize.fill = GridBagConstraints.HORIZONTAL;
				gbc_spSize.anchor = GridBagConstraints.WEST;
				gbc_spSize.insets = new Insets(0, 0, 5, 5);
				gbc_spSize.gridx = 2;						//column index
				gbc_spSize.gridy = 4;						//row index
				this.spSize.addChangeListener(new ChangeListener() {
					
					@Override
					public void stateChanged(ChangeEvent e) {
						if (RealEstatePanel.this.realEstate!=null)
							RealEstatePanel.this.realEstate.setSize(((Number)RealEstatePanel.this.spSize.getValue()).intValue());
					}
				});
				add(this.spSize, gbc_spSize);
	}
	
	/**
	 * Set the current computer data
	 * 
	 * @param computer the current data
	 */
	public void setData(RealEstate realEstate) {
		this.realEstate = realEstate;
		if (this.realEstate!=null) {
			this.tfAddress.setText(realEstate.getAddress());
			this.cbType.setSelectedIndex(realEstate.getType());
			this.spPrice.setValue(Integer.valueOf(realEstate.getPrice()));
			this.spAge.setValue(Integer.valueOf(realEstate.getAge()));
			this.spSize.setValue(Integer.valueOf(realEstate.getSize()));
			return;
		}
		this.tfAddress.setText(null); 
		this.cbType.setSelectedIndex(RealEstate.TYPE_UNKNOWN);
		this.spPrice.setValue(Integer.valueOf(0));
		this.spAge.setValue(Integer.valueOf(0));
		this.spSize.setValue(Integer.valueOf(0));
	}
	
	/**
	 * returns the current data object
	 * 
	 * @return the current data
	 */
	
	public RealEstate getData() {
		return this.realEstate;
	}

	public void readInitialStatus() {
		if(this.realEstate == null)
			this.realEstate = new RealEstate();
			this.realEstate.setAddress(this.tfAddress.getText());
			this.realEstate.setPrice((int) this.spPrice.getValue());
			this.realEstate.setAge((int) this.spAge.getValue());
			this.realEstate.setSize((int) this.spSize.getValue());
			this.realEstate.setType(this.cbType.getSelectedIndex());
			
		
	}
}
