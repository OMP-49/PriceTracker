/**
 * 
 */
package priceTracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import priceTracker.model.Product;
import priceTracker.service.PriceService;

/**
 * @author om
 *
 */

@RestController
public class PriceAlertController {
	
	@Autowired
	PriceService priceService;
	
	@PostMapping("/trackPrice")
	public ResponseEntity<Object> trackProductPrice(Product product){
		
		return null;
	}

}
