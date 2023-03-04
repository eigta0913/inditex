package com.soaint.inditex.domain.service;

import java.time.LocalDateTime; 

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.soaint.inditex.domain.dao.PriceDao;
import com.soaint.inditex.domain.entity.Prices;
import com.soaint.inditex.domain.exceptions.PriceNotFoundException;
import com.soaint.inditex.domain.vo.PriceVO;
 

@Service
public class PriceServiceImpl implements PriceService {
	
	@Autowired
	private PriceDao priceDao;
	
	@Autowired
    private ModelMapper modelMapper;
	
	public PriceVO getCurrentProductPrice(LocalDateTime applyDate, Long productId, Long brandId) throws PriceNotFoundException { 
		
		try { 
			Prices price = priceDao.getCurrentProductPrice(applyDate, productId, brandId); 
			return modelMapper.map(price, PriceVO.class); 
		}catch (EmptyResultDataAccessException e) {
			throw new PriceNotFoundException("No se encontró precio con los parámetros recibidos brand id: " + brandId + ", product id:" + productId + " apply date: " + applyDate);
		}
		 
	}

}
