package org.mik.realestate.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AbstractDomain implements Domain, Serializable {

	/**
	 * Logging facility.
	 * 
	 * Very important the real error information for debugging and supporting.  
	 */
	private final static Logger LOG =  Logger.getLogger(AbstractDomain.class.getName());
	
	/**
	 * Name of id field on database table
	 */
	public final static String COL_ID="id"; //$NON-NLS-1$
	
	/**
	 * The id field
	 */
	private Integer id;

	/**
	 * Default constructor.
	 * 
	 * 
	 */
	public AbstractDomain() {
	
	}
	
	/**
	 * Constructor from Database ResultSet.
	 * 
	 * @param rs the resultset
	 */
	public AbstractDomain(ResultSet rs) {
		try {
			this.id=Integer.valueOf(rs.getInt(rs.findColumn(COL_ID)));
		}
		catch(Exception e) {
			LOG.log(Level.ALL, e.getMessage());
			this.id=null;
		}
	}
		
	/**
	 * Getter for id
	 * 
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * Setter for id.
	 * 
	 * @param id the new id value
	 */
	@Override
	public void setId(Integer id) {
		this.id=id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractDomain other = (AbstractDomain) obj;
		if (this.id == null) {
			if (other.id != null)
				return false;
		} else if (!this.id.equals(other.id))
			return false;
		return true;
	}
	

}
