package com.everis.school.stockms.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

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

	@Test
	public void save() throws BusinessException {
		Stock stock = new Stock();
		stock.setId(1);
		stock.setProductId(1);
		stock.setWareHouseId(2);
		stock.setQuantity(2);

		List<Stock> stocks = new ArrayList<>();
		stocks.add(stock);

		when(repository.saveAll(stocks)).thenReturn(stocks);

		List<Stock> result = service.save(stocks);

		assertNotNull(result);
		assertEquals(1, result.get(0).getId());
		assertEquals(1, result.get(0).getProductId());
		assertEquals(2, result.get(0).getWareHouseId());
		assertEquals(2, result.get(0).getQuantity());
	}

	@Test
	public void testFindByProductId() {
		Stock stock = new Stock();
		stock.setId(1);
		stock.setProductId(1);
		stock.setWareHouseId(2);
		stock.setQuantity(2);

		List<Stock> stocks = new ArrayList<>();
		stocks.add(stock);

		when(repository.findByProductId(1)).thenReturn(stocks);

		List<Stock> result = service.findByProductId(1);

		assertNotNull(result);
		assertEquals(1, result.size());
		assertNotNull(result);
		assertEquals(1, result.get(0).getId());
		assertEquals(1, result.get(0).getProductId());
		assertEquals(2, result.get(0).getWareHouseId());
		assertEquals(2, result.get(0).getQuantity());
	}

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
