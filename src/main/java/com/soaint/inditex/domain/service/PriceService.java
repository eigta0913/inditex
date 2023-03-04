package com.soaint.inditex.domain.service;

import java.time.LocalDateTime;

import com.soaint.inditex.domain.exceptions.PriceNotFoundException;
import com.soaint.inditex.domain.vo.PriceVO;

public interface PriceService {
	
	
	PriceVO getCurrentProductPrice(LocalDateTime applyDate, Long productId, Long brandId) throws PriceNotFoundException;

}
