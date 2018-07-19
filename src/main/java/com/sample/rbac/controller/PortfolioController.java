/**
 * 
 */
package com.sample.rbac.controller;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.rbac.exception.LEDApplicationException;
import com.sample.rbac.model.Portfolio;
import com.sample.rbac.service.PortfolioService;

/**
 * @author NishigandhaomanwarOm
 *
 */
@CrossOrigin(origins = "*", allowedHeaders = {"Content-Type", "Accept", "X-Requested-With", "remember-me","Origin","Last-Modified", "Content-Disposition", "attachment"})
@RestController
@RequestMapping("api/portfolio")
public class PortfolioController {

private static final Logger log = LoggerFactory.getLogger(PortfolioController.class);
	
	@Autowired
	private PortfolioService portfolioService;	
	
	@GetMapping("/fetchAll")
	public List<Portfolio> getAllPortFolios() {	
		log.info("Fetching All portfolios from databse.");		
	    return portfolioService.getAllPortfolios();
	}	
	
//	@GetMapping("/fetchAllTrees")
//	public List<PortfolioTree> getAllPortFolioTree() {	
//		log.info("Fetching All portfolio trees from databse.");		
//	    return portfolioService.fetchPortfolioTree();
//	}
//	
//	@GetMapping("/getRootportfolio")
//	public Portfolio getRootPortfolio() {	
//		log.info("Fetching Root portfolio from databse.");		
//		return portfolioService.getRootPortfolioDetails();
//	}
//	
	@GetMapping("/getPortfoliobyId/{id}")
	public Portfolio getPortfolioById(@PathVariable(value = "id") Long portfolioId) throws LEDApplicationException {	
		log.info("Fetching portfolio by ID" +portfolioId  +"from databse.");
        
		
		log.info("Fetching portfolio by ID" +portfolioId  +"from databse.");		
	    return portfolioService.getPortfolioById(portfolioId);
        
	}
//	
//	@PutMapping("/createSubPortfolio/{parentId}")
//	public Portfolio createPortfolio(@PathVariable (value = "parentId") Long parentId, @Valid @RequestBody Portfolio portfolio) {	
//		log.info("Creating portfolio.");		
//	    return portfolioService.createPortfolio(parentId, portfolio);
//	}
	
	@PostMapping("/editPortfolio/{portfolioId}")
	public Portfolio editPortfolio(@PathVariable (value = "portfolioId") Long portfolioId, @Valid @RequestBody Portfolio portfolio) {	
		log.info("Updating portfolio in databse.");		
	    return portfolioService.editPortfolio(portfolio);
	}
	
	@GetMapping("/deactivatePortfolio/{portfolioId}")
	public Portfolio deactivatePortfolio(@PathVariable (value = "portfolioId") Long portfolioId) throws LEDApplicationException {	
		log.info("Deactivating portfolio" +portfolioId);		
	    return portfolioService.deactivatePortfolio(portfolioId);
	}
	
	@GetMapping("/activatePortfolio/{portfolioId}")
	public Portfolio activatePortfolio(@PathVariable (value = "portfolioId") Long portfolioId) {	
		log.info("Activating portfolio" +portfolioId);		
	    return portfolioService.activatePortfolio(portfolioId);
	}
}
