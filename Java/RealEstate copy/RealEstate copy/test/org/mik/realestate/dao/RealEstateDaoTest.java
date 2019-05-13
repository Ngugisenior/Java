package org.mik.realestate.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mik.realestate.dao.RealEstateDao;
import org.mik.realestate.domain.RealEstate;

public class RealEstateDaoTest {

	private final static String ADDRESS = "Address"; //$NON-NLS-1$
	private final static String FIND_ADDRESS = "Find address"; //$NON-NLS-1$
	private final static String MODIFIED_ADDRESS = "New address"; //$NON-NLS-1$

	private RealEstateDao dao;

	@Before
	public void init() {
		this.dao = RealEstateDao.createRealEstateDao();
	}

	@After
	public void shutdown() {
		this.dao.shutdown();
	}

	@Test
	public void test() {
		insertUpdateDeleteTest();
		deleteAllTest();
		findTest();
		deleteAllTest();
		selectTest();
		deleteAllTest();
	}

	public void insertUpdateDeleteTest() {
		assertNotNull(this.dao);
		RealEstate realEstate = new RealEstate();
		realEstate.setSize(120);
		assertEquals(realEstate.getSize(), 120);
		realEstate.setAge(2);
		assertEquals(realEstate.getAge(), 2);
		realEstate.setAddress(ADDRESS);
		assertEquals(ADDRESS.compareTo(realEstate.getAddress()), 0);
		realEstate.setPrice(80);
		assertEquals(realEstate.getPrice(), 80);
		realEstate.setType(RealEstate.TYPE_DUPLEX);
		assertEquals(realEstate.getType(), RealEstate.TYPE_DUPLEX);
		RealEstate newRealEstate = this.dao.insert(realEstate);
		Integer newId = newRealEstate.getId();
		assertNotNull(newId);
		newRealEstate.setAddress(MODIFIED_ADDRESS);
		this.dao.update(newRealEstate);
		assertEquals(MODIFIED_ADDRESS.compareTo(newRealEstate.getAddress()),0);
		try {
			this.dao.delete(newRealEstate);
		}
		catch(Exception e) {
			e.printStackTrace();
			fail();
		}		
	}
	
	public void deleteAllTest() {
		assertNotNull(this.dao);
		try {
			this.dao.deleteAll();
		}
		catch(Exception e) {
			e.printStackTrace();
			fail();
		}	
	}
	 
	public void selectTest() {
		assertNotNull(this.dao);
		RealEstate realEstate = new RealEstate();
		realEstate.setSize(120);
		assertEquals(realEstate.getSize(), 120);
		realEstate.setAge(2);
		assertEquals(realEstate.getAge(), 2);
		realEstate.setAddress(ADDRESS);
		assertEquals(ADDRESS.compareTo(realEstate.getAddress()), 0);
		realEstate.setPrice(80);
		assertEquals(realEstate.getPrice(), 80);
		realEstate.setType(RealEstate.TYPE_DUPLEX);
		assertEquals(realEstate.getType(), RealEstate.TYPE_DUPLEX);
		this.dao.insert(realEstate);
		
		realEstate = new RealEstate();
		realEstate.setSize(130);
		assertEquals(realEstate.getSize(), 130);
		realEstate.setAge(4);
		assertEquals(realEstate.getAge(), 4);
		realEstate.setAddress(MODIFIED_ADDRESS);
		assertEquals(MODIFIED_ADDRESS.compareTo(realEstate.getAddress()), 0);
		realEstate.setPrice(100);
		assertEquals(realEstate.getPrice(), 100);
		realEstate.setType(RealEstate.TYPE_MANSION);
		assertEquals(realEstate.getType(), RealEstate.TYPE_MANSION);
		this.dao.insert(realEstate);
		
		int cnt=0;
		List<RealEstate> all = this.dao.listOrderById();
		for(RealEstate c:all) {
			assertNotNull(c.getId());
			++cnt;
		}
		assertEquals(cnt, 2);
	}
	
	public void findTest() {
		assertNotNull(this.dao);
		RealEstate realEstate = new RealEstate();
		realEstate.setAddress(FIND_ADDRESS);
		realEstate.setSize(120);
		realEstate.setPrice(80);
		realEstate.setType(RealEstate.TYPE_APARTMENT);
		RealEstate nc=this.dao.insert(realEstate);
		RealEstate fc=this.dao.findById(nc.getId());
		assertEquals(nc,  fc);
		fc=this.dao.findByAddress(FIND_ADDRESS);
		assertEquals(fc, nc);
		try {
			this.dao.delete(fc);
		}
		catch(Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
