package org.mik.realestate.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.mik.realestate.domain.RealEstate;

public class RealEstateDao extends AbstractDao<RealEstate> {

	private static final String SQL_FIND_BY_ID = "SELECT * FROM realestate r WHERE id = ?"; //$NON-NLS-1$

	private static final String SQL_FIND_BY_ADDRESS = "SELECT * FROM realestate r WHERE address = ?"; //$NON-NLS-1$

	private static final String SQL_LIST_ORDER_BY_ID = "SELECT * FROM realestate r ORDER BY id"; //$NON-NLS-1$

	private static final String SQL_INSERT = "INSERT INTO realestate (" //$NON-NLS-1$
			+ RealEstate.COL_ADDRESS + ", " //$NON-NLS-1$
			+ RealEstate.COL_TYPE + "," //$NON-NLS-1$
			+ RealEstate.COL_PRICE + "," //$NON-NLS-1$
			+ RealEstate.COL_AGE + "," //$NON-NLS-1$
			+ RealEstate.COL_SIZE + ") VALUES (?, ?, ?, ?, ?)"; //$NON-NLS-1$

	private static final String SQL_UPDATE = "UPDATE realestate SET " //$NON-NLS-1$
			+ RealEstate.COL_ADDRESS + "=?," //$NON-NLS-1$
			+ RealEstate.COL_TYPE + "= ?, " //$NON-NLS-1$
			+ RealEstate.COL_PRICE + "=?," //$NON-NLS-1$
			+ RealEstate.COL_AGE + " = ?, " //$NON-NLS-1$
			+ RealEstate.COL_SIZE + " = ? WHERE id = ?"; //$NON-NLS-1$

	private static final String SQL_CREATE_TABLE = "CREATE TABLE if not exists realestate ( id integer identity primary key, "+  //$NON-NLS-1$
                              RealEstate.COL_ADDRESS + " varchar(140), " +  //$NON-NLS-1$
                              RealEstate.COL_TYPE + " int," +  //$NON-NLS-1$
                              RealEstate.COL_PRICE + " int,"+  //$NON-NLS-1$
                              RealEstate.COL_AGE + " int,"+ //$NON-NLS-1$
                              RealEstate.COL_SIZE + " int);"; //$NON-NLS-1$
	
	private static final String SQL_DELETE = "DELETE FROM realestate WHERE id = ?"; //$NON-NLS-1$

	private static final String SQL_DELETE_ALL = "DELETE FROM realestate"; //$NON-NLS-1$

	public RealEstateDao(String url, String user, String password) {
		super(url, user, password);
		checkRealEstateTable();
	}


	@Override
	protected RealEstate createDomain(ResultSet rs) {
		return new RealEstate(rs);
	}

	public RealEstate findById(Integer id) {
		return find(SQL_FIND_BY_ID, id);
	}

	public RealEstate findByAddress(String address) {
		return find(SQL_FIND_BY_ADDRESS, address);
	}

	public List<RealEstate> listOrderById() {
		return list(SQL_LIST_ORDER_BY_ID);
	}

	@Override
	protected Object[] getDomainValues(RealEstate domain) {
		return new Object[] { domain.getAddress(),
				Integer.valueOf(domain.getType()),
				Integer.valueOf(domain.getPrice()),
				Integer.valueOf(domain.getAge()),
				Integer.valueOf(domain.getSize()) };
	}

	@Override
	protected Object[] getDomainValuesForUpdate(RealEstate domain) {
		return new Object[] { domain.getAddress(),
				Integer.valueOf(domain.getType()),
				Integer.valueOf(domain.getPrice()),
				Integer.valueOf(domain.getAge()),
				Integer.valueOf(domain.getSize()),
				domain.getId()
		};
	}

	@Override
	protected String getInsertSql() {
		return SQL_INSERT;
	}

	@Override
	protected String getDeleteSql() {
		return SQL_DELETE;
	}

	@Override
	protected String getDeleteAllSql() {
		return SQL_DELETE_ALL;
	}

	@Override
	protected String getUpdateSql() {
		return SQL_UPDATE;
	}
	
	public static RealEstateDao createRealEstateDao() {
		RealEstateDao result = new RealEstateDao(DB_URI, DB_USER, DB_PASSWORD);
		return result;
	}

	private void checkRealEstateTable() {
		try (Statement stmt = this.connection.createStatement()) {
			stmt.execute(SQL_CREATE_TABLE);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}


}
