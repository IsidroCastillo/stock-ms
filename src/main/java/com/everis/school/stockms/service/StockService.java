package com.everis.school.stockms.service;

import java.util.List;

import com.everis.school.stockms.entity.Stock;
import com.everis.school.stockms.exception.BusinessException;

public interface StockService {

	List<Stock> findByProductId(Integer productId);

	public List<Stock> save(List<Stock> stocks) throws BusinessException;

}
