package com.soaint.inditex.domain.dao;
  
 
import java.time.LocalDateTime; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.soaint.inditex.domain.entity.Prices;

import jakarta.persistence.EntityManager; 
import jakarta.persistence.TypedQuery; 

@Repository
public class PriceDaoImpl implements PriceDao{
  
	@Autowired
	private EntityManager em;
 
	
	public Prices getCurrentProductPrice(LocalDateTime appyDate, Long productId, Long brandId) { 
		
		TypedQuery<Prices> query = em.createQuery("from Prices p "
										+ "	where p. productId = ?1 "
										+ " and brandId = ?2 "
										+ " and startDate <= ?3 and endDate  >=?4 "
										+ " order by priority DESC limit 1", Prices.class); 
		
		query.setParameter(1, productId);
		query.setParameter(2, brandId); 
		query.setParameter(3,  appyDate);
		query.setParameter(4,  appyDate);
		
		return query.getSingleResult();

	}

}
