package com.soaint.inditex.domain.dao;
   
import java.time.LocalDateTime;

import com.soaint.inditex.domain.entity.Prices;
 

public interface PriceDao {
 
	Prices getCurrentProductPrice(LocalDateTime applicationDate, Long productId, Long brandId);

}
