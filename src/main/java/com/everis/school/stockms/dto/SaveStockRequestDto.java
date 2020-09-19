package com.everis.school.stockms.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveStockRequestDto {
	private Integer id;
	private Integer productId;
	private Integer wareHouseId;
	private Integer quantity;
}
