package com.everis.school.stockms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.everis.school.stockms.dto.FindByProductIdDto;
import com.everis.school.stockms.dto.SaveStockResponseDto;
import com.everis.school.stockms.entity.Stock;
import com.everis.school.stockms.exception.BusinessException;
import com.everis.school.stockms.mapper.StockMapper;
import com.everis.school.stockms.service.StockService;

@RestController
public class StockController {

	@Autowired
	private StockService stockService;

	@PostMapping("stock")
	public List<SaveStockResponseDto> save(@RequestBody List<Stock> stocks) throws BusinessException {
		return StockMapper.INSTANCE.saveStockResponseDtos(stockService.save(stocks));
	}

	@GetMapping("stock/{productId}")
	public FindByProductIdDto findByProductId(@PathVariable("productId") Integer productId) {
		List<Stock> lista = stockService.findByProductId(productId);
		int total = lista.stream().mapToInt(Stock::getQuantity).sum();
		return StockMapper.INSTANCE.toReport(new Stock(productId, total));

	}

}
