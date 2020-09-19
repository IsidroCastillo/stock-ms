package com.everis.school.stockms.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SaveStockResponseDto {
	private Integer id;
	private Integer productId;
	private Integer wareHouseId;
	private Integer quantity;
}
