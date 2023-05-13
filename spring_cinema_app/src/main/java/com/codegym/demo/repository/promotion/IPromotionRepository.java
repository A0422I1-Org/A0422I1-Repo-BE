package com.codegym.demo.repository.promotion;


import com.codegym.demo.model.promotion.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPromotionRepository  extends JpaRepository<Promotion,Integer> {
}
