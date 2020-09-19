
package com.everis.school.stockms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "stock")
@NoArgsConstructor
@ToString
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "product_id")
	private Integer productId;

	@Column(name = "ware_house_id")
	private Integer wareHouseId;

	@Column()
	private Integer quantity;

	public Stock(Integer productId, Integer quantity) {
		this.productId = productId;
		this.quantity = quantity;
	}

}
