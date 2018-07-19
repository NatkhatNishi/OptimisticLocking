package com.sample.rbac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.rbac.exception.LEDApplicationException;
import com.sample.rbac.model.Portfolio;
import com.sample.rbac.repository.PortfolioRepository;

@Service
public class PortfolioService {
	
	@Autowired
	private PortfolioRepository repository;
	
	public Portfolio editPortfolio(Portfolio portfolio) {	
//		Optional<Portfolio> portfolioFromDB = repository.findById(portfolio.getId());
//		Portfolio portfolioToBeUpdated = portfolioFromDB.get();
//		portfolioToBeUpdated.setId(portfolio.getId());
//		portfolioToBeUpdated = portfolio;
//		portfolio.setVersion(portfolio.getVersion() +1);
		return repository.save(portfolio);
	}
	
	public Portfolio deactivatePortfolio(Long portfolioId) throws LEDApplicationException {
		Optional<Portfolio> portfolioFromDB = repository.findById(portfolioId);
		if(portfolioFromDB.isPresent()) {
		Portfolio portfolioToBeUpdated = portfolioFromDB.get();
		portfolioToBeUpdated.setActive("N");
//		portfolioToBeUpdated.setVersion(portfolioToBeUpdated.getVersion() +1);
		return repository.save(portfolioToBeUpdated);
		} else {
			throw new LEDApplicationException("ID not Found", "101");
		}
		
	}
	
	public Portfolio activatePortfolio(Long portfolioId) {
		Optional<Portfolio> portfolioFromDB = repository.findById(portfolioId);
		Portfolio portfolioToBeUpdated = portfolioFromDB.get();
		portfolioToBeUpdated.setActive("Y");
		return repository.save(portfolioToBeUpdated);
	}
	
	public List<Portfolio> getAllPortfolios() {
		return repository.findAll();
	}

	public Portfolio getPortfolioById(Long portfolioId) throws LEDApplicationException {
		return repository.findById(portfolioId).orElseThrow(() -> new LEDApplicationException("No portfolio found for this ID", "LED103"));
	}
	
	public Portfolio fetchPortfolio(Long portfolioId) {
		return repository.getOne(portfolioId);
	}
	
//	public List<PortfolioTree> fetchPortfolioTree() {
//		return portfolioTreeRepository.findAll();
//	}
	
//	public Portfolio getRootPortfolioDetails() {
//		List<Portfolio> allPortfolios = repository.findAll();
//		List<PortfolioTree> portfolioTrees = portfolioTreeRepository.findAll();
//		Map<Long, List<Portfolio>> parentChildMap = new HashMap<Long, List<Portfolio>>();
////		Create Map of all portfolios and Id
//		Map<Long, Portfolio> portfolioMap = allPortfolios.stream().collect(Collectors.toMap(p -> p.getId(), p -> p));
////		Create Map of parent and its list of child
//		for(PortfolioTree p : portfolioTrees) {
//			List<Portfolio> childPortfolios = new ArrayList<Portfolio>();
//			for(PortfolioTree p1 : portfolioTrees) {
//				if(p1.getParentPortfolioId() == p.getId()) {
//					Portfolio childPortfolio = portfolioMap.get(p1.getChildPortfolioId());
//					childPortfolio.setParentId(p1.getId());
//					childPortfolios.add(childPortfolio);
//				}
//			}
////			Update the portfolios with updated child nodes in map.
//			parentChildMap.put(p.getId(),childPortfolios );
//		}
//		
////		Get ID of RootProfile and fetch it from portfoli map
//		for(Portfolio p : allPortfolios) {
//			p.setChildren(parentChildMap.get(p.getId()));
//			portfolioMap.put(p.getId(), p);
//		}
//		
//		 return portfolioMap.get(repository.getRootportfolioID());
//	}
}
