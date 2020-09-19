package com.everis.school.stockms.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.everis.school.stockms.entity.Stock;
import com.everis.school.stockms.exception.BusinessException;
import com.everis.school.stockms.repository.StockRepository;

@RunWith(MockitoJUnitRunner.class)
public class TestStockServiceShould {

	@InjectMocks
	private StockServiceImpl service;

	@Mock
	private StockRepository repository;

	@Test(expected = BusinessException.class)
	public void testSaveWhenException() throws BusinessException {

		Stock stock = new Stock();
		stock.setId(1);
		stock.setProductId(1);
		stock.setWareHouseId(2);
		stock.setQuantity(0);

		List<Stock> stocks = new ArrayList<>();
		stocks.add(stock);

		service.save(stocks);

	}

}
