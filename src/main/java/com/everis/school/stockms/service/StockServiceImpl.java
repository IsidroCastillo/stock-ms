package com.everis.school.stockms.service;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.school.stockms.entity.Stock;
import com.everis.school.stockms.exception.BusinessException;
import com.everis.school.stockms.repository.StockRepository;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	private StockRepository stockRepository;

	@Override
	public List<Stock> save(List<Stock> stocks) throws BusinessException {
		for (Stock stock : stocks) {
			if (stock.getQuantity() <= 0) {
				throw new BusinessException("Quantity of product cannot be 0");
			}
		}
		return stockRepository.saveAll(stocks);
	}

	@Override
	public List<Stock> findByProductId(Integer productId) {
		return stockRepository.findByProductId(productId);
	}

}
