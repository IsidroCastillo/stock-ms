package com.everis.school.stockms.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FindByProductIdDto {
	private Integer productId;
	private Integer total;
}
