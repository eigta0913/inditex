package com.soaint.inditex.controller;
 
import java.time.LocalDateTime; 

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.soaint.inditex.domain.exceptions.PriceNotFoundException;
import com.soaint.inditex.domain.service.PriceService;
import com.soaint.inditex.domain.vo.PriceVO;

@RestController
@RequestMapping("/product")
public class PriceController {
	
	@Autowired
	private PriceService priceService;
	
	@GetMapping(value="price")
	@ResponseBody
	public PriceVO getPrice(@RequestParam(value="brandId") Long brandId, 
								@RequestParam(value="productId") Long productId,
								@RequestParam(value="applyDate") LocalDateTime  applyDate ) throws PriceNotFoundException {
		
		return priceService.getCurrentProductPrice(applyDate, productId, brandId);
	}
	
	
	

}
