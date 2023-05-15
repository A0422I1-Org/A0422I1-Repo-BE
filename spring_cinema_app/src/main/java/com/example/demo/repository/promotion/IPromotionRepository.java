package com.example.demo.repository.promotion;

import com.example.demo.model.promotion.PromotionV02;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IPromotionRepository  extends JpaRepository<PromotionV02,Integer> {
    @Query(value = "SELECT p FROM PromotionV02 p WHERE p.isDelete=false ", nativeQuery = false)
    List<PromotionV02> findAll();

    @Query(value = "SELECT p FROM PromotionV02 p WHERE p.id=?1 and p.isDelete=false", nativeQuery = false)
    Optional<PromotionV02> findById(Integer id);
}
