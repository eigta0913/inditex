package com.soaint.inditex;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import com.soaint.inditex.InidtexApplication;
import com.soaint.inditex.domain.vo.PriceVO; 

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = InidtexApplication.class)
@Sql({ "/schema.sql", "/data.sql" })
class InidtexApplicationTests {


	@Value(value="${local.server.port}")
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	 
	
	@Test
	void test1() {  
		ResponseEntity<PriceVO> response =  this.restTemplate.getForEntity(getUrl((long)1, (long)35455, "2020-06-14-10.00.00"), PriceVO.class); 
		assertEquals(response.getStatusCode().value(), HttpStatus.OK.value()); 
		assertEquals(response.getBody().getPrice().doubleValue(), (double)35.50);  
	}
	
	@Test
	void test2() {  
		ResponseEntity<PriceVO> response =  this.restTemplate.getForEntity(getUrl((long)1, (long)35455, "2020-06-14-16.00.00"), PriceVO.class); 
		assertEquals(response.getStatusCode().value(), HttpStatus.OK.value()); 
		assertEquals(response.getBody().getPrice().doubleValue(), (double)25.45);  
	}
	
	@Test
	void test3() {  
		ResponseEntity<PriceVO> response =  this.restTemplate.getForEntity(getUrl((long)1, (long)35455, "2020-06-14-21.00.00"), PriceVO.class); 
		assertEquals(response.getStatusCode().value(), HttpStatus.OK.value()); 
		assertEquals(response.getBody().getPrice().doubleValue(), (double)35.5);  
	}
	
	@Test
	void test4() {  
		ResponseEntity<PriceVO> response =  this.restTemplate.getForEntity(getUrl((long)1, (long)35455, "2020-06-15-10.00.00"), PriceVO.class); 
		assertEquals(response.getStatusCode().value(), HttpStatus.OK.value()); 
		assertEquals(response.getBody().getPrice().doubleValue(), (double)30.5);  
	}
	
	@Test
	void test5() {  
		ResponseEntity<PriceVO> response =  this.restTemplate.getForEntity(getUrl((long)1, (long)35455, "2020-06-21-16.00.00"), PriceVO.class); 
		assertEquals(response.getStatusCode().value(), HttpStatus.OK.value()); 
		assertEquals(response.getBody().getPrice().doubleValue(), (double)38.95);  
	}
	
	@Test
	void additionalTest() {  
		ResponseEntity<String> response =  this.restTemplate.getForEntity(getUrl((long)1, (long)35455, "2022-06-21-16.00.00"), String.class); 
		assertEquals(response.getStatusCode().value(), HttpStatus.BAD_REQUEST.value()); 
		assertThat(response.getBody()).isNotNull();
		  
	}
	
	public String getUrl(Long brandId, Long productId, String applyDate) {
		return "http://localhost:" + port + "/product/price?" + "brandId=" + brandId +  "&productId=" + productId +  "&applyDate=" + applyDate;
	}

}
