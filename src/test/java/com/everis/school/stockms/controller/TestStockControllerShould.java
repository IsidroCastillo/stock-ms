package com.everis.school.stockms.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.everis.school.stockms.dto.FindByProductIdDto;
import com.everis.school.stockms.dto.SaveStockResponseDto;
import com.everis.school.stockms.entity.Stock;
import com.everis.school.stockms.exception.BusinessException;
import com.everis.school.stockms.service.StockService;

@RunWith(MockitoJUnitRunner.class)
public class TestStockControllerShould {

	@InjectMocks
	private StockController controller;

	@Mock
	private StockService service;

	@Test
	public void testSave() throws BusinessException {
		Stock stock = new Stock();
		stock.setQuantity(8);
		Stock stock2 = new Stock();
		stock2.setQuantity(10);

		List<Stock> stocks = new ArrayList<>();
		stocks.add(stock);
		stocks.add(stock2);

		when(service.save(stocks)).thenReturn(stocks);

		List<SaveStockResponseDto> result = controller.save(stocks);

		assertEquals(2, result.size());
		assertNotNull(result);
	}

	@Test
	public void testFindByProductId() {
		FindByProductIdDto lista = controller.findByProductId(2);
//		int total = lista.stream().mapToInt(Stock::getQuantity).sum();
	}

}
