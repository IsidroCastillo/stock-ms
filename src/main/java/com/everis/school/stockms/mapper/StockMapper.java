package com.everis.school.stockms.mapper;

import java.time.Instant;
import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.everis.school.stockms.dto.ErrorDetailDto;
import com.everis.school.stockms.dto.FindByProductIdDto;
import com.everis.school.stockms.dto.SaveStockRequestDto;
import com.everis.school.stockms.dto.SaveStockResponseDto;
import com.everis.school.stockms.entity.Stock;

@Mapper(componentModel = "spring")
public interface StockMapper {

	StockMapper INSTANCE = Mappers.getMapper(StockMapper.class);

	@Mapping(source = "stock.productId", target = "productId")
	@Mapping(source = "stock.quantity", target = "total")
	public FindByProductIdDto toReport(Stock stock);

	public ErrorDetailDto errorDetailDto(Stock stock);

	public Stock toEntity(SaveStockRequestDto saveStockRequestDto);

	public SaveStockResponseDto toSaveStockResponseDto(Stock stock);

	public List<SaveStockResponseDto> saveStockResponseDtos(List<Stock> stocks);

	@AfterMapping
	default void setRemainingValues(Stock stock, @MappingTarget ErrorDetailDto errorDetailDto) {
		errorDetailDto.setDateTime(Integer.valueOf(stock.getQuantity()) <= 0 ? Instant.now() : null);
	}
}
