package com.example.demo.repository.promotion;


import com.example.demo.model.promotion.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPromotionRepository  extends JpaRepository<Promotion,Integer> {
}
