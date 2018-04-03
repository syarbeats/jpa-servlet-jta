package com.cdc.mitrais.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.cdc.mitrais.jpa.entity.Geek;
import com.cdc.mitrais.jpa.listener.PersonListener;

public class GeekDAO implements IGeekDAO{

	private EntityManager entityManager = null;
	
	public GeekDAO() {
		
	}
	
	public EntityManager getEntityManager() {
		this.entityManager = PersonListener.createEntityManager();
		return entityManager;
	}
	
	public void closeEntityManager() {
		if(entityManager != null) {
			this.entityManager.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Geek> getAllGeek() {
		
		return getEntityManager().createQuery("Select e FROM Geek e").getResultList();
	}
	
	

}
