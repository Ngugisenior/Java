package org.mik.realestate.domain;

import java.sql.ResultSet;

/**
 * RealEstate domain 
 * 
 * Inherits AbstractDomain (id field)
 *
 *
 */
public class RealEstate extends AbstractDomain {
	
	/**
	 * Name of each columns in database
	 *  
	 */
	public final static String COL_TYPE="type"; //$NON-NLS-1$
	
	public final static String COL_PRICE="price"; //$NON-NLS-1$
	
	public final static String COL_AGE="age"; //$NON-NLS-1$
	
	public final static String COL_SIZE="size"; //$NON-NLS-1$
	
	public final static String COL_ADDRESS="address"; //$NON-NLS-1$
	
	
	/**
	 * RealEstate types 
	 */
	
	public final static int TYPE_APARTMENT=0;
	public final static int TYPE_BUNGALOW=1;
	public final static int TYPE_DUPLEX=2;
	public final static int TYPE_MANSION=3;
	public final static int TYPE_UNKNOWN = 4;
	
	
	/**
	 * RealEstate type names as string array
	 */
	public final static String TYPE_VALUES[]={"Apartment", "Bungalow", "Duplex", "Mansion", "Unknown" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ 
	
	
	
	
	/**
	 * type of RealEstate
	 */
	private int type;
	
	/**
	 * price of RealEstate 
	 */
	private int price;
	
	/**
	 * age of RealEstate  */
	
	private int age;
	
	/**
	 * size of RealEstate
	 */
	private int size;
	
	/**
	 * address of RealEstate
	 */
	private String address;
	
	
	
		
	/**
	 * Default constructor (empty RealEstate)
	 */
	public RealEstate() {
		this.type=TYPE_UNKNOWN;
		
	}
	
	/**
	 * Constructor from database resultset.
	 * 
	 * @param rs
	 */
	public RealEstate(ResultSet rs) {
		super(rs);
		try {
			this.type=rs.getInt(rs.findColumn(COL_TYPE));
			this.price = rs.getInt(rs.findColumn(COL_PRICE));
			if (this.type< 0 ||this.type>TYPE_UNKNOWN)
				this.type=TYPE_UNKNOWN;
			
			this.age=rs.getInt(rs.findColumn(COL_AGE));
			this.size = rs.getInt(rs.findColumn(COL_SIZE));
			this.address = rs.getString(rs.findColumn(COL_ADDRESS));
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	

	/**
	 * Getter for type
	 * 
	 * @return type as integer
	 */
	public int getType() {
		return this.type;
	}

	/**
	 * Getter for type as string
	 * 
	 * @return the type as string
	 */
	public String getTypeAsString() {
		switch (this.type) {
		case TYPE_APARTMENT:return TYPE_VALUES[0];
		case TYPE_BUNGALOW : return TYPE_VALUES[1];
		case TYPE_DUPLEX : return TYPE_VALUES[2];
		case TYPE_MANSION : return TYPE_VALUES[3];
		default : return TYPE_VALUES[4];
		}
	}
	
	/**
	 * Setter for type. 
	 * 
	 * if the new type is out from type interval, it sets to unknown
	 * 
	 * @param type the new type as integer
	 */
	public void setType(int type) {
		this.type = type<0 || type>TYPE_UNKNOWN ? TYPE_UNKNOWN : type;
	}

	/**
	 * Getter for price in $
	 * 
	 * @return price as $
	 */
	public int getPrice() {
		return this.price;
	}

	/**
	 * Setter for price
	 * 
	 * @param price
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	
	/**
	 * Getter for age
	 * 
	 * @return age
	 */
	public int getAge() {
		return this.age;
	}

	/**
	 * Setter for age
	 * 
	 * @param age the new age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Getter for size
	 * 
	 * @return size
	 */
	public int getSize() {
		return this.size;
	}

	/**
	 * Setter for size
	 * 
	 * @param size the new size
	 */
	public void setSize(int size) {
		this.size = size;
	}
	
	/**
	 * Getter for address
	 * 
	 * @return address
	 */
	public String getAddress() {
		return this.address;
	}

	/**
	 * Setter for address
	 * 
	 * @param address the new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + this.price;
		result = prime * result + this.age;
		result = prime * result + this.size;
		result = prime * result + ((this.address == null) ? 0 : this.address.hashCode());
		result = prime * result + this.type;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		RealEstate other = (RealEstate) obj;
		if (this.price != other.price)
			return false;
		if (this.size != other.size)
			return false;
		if (this.age != other.age)
			return false;
		if (this.address == null) {
			if (other.address != null)
				return false;
		} else if (!this.address.equals(other.address))
			return false;
		if (this.type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return new StringBuffer("RealEstate ") //$NON-NLS-1$
				.append("id:").append(getId()) //$NON-NLS-1$
				.append(", type:").append(getTypeAsString()) //$NON-NLS-1$
				.append(", price:").append(getPrice()) //$NON-NLS-1$
				.append(", age:").append(getAge()) //$NON-NLS-1$
				.append(", size:").append(getSize()) //$NON-NLS-1$
				.append(", address:").append(getAddress()) //$NON-NLS-1$
				.toString(); 
	}
	
}
