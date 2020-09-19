package com.everis.school.stockms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.school.stockms.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

	List<Stock> findByProductId(Integer productId);

}
