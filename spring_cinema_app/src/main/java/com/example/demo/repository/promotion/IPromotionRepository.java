package com.example.demo.repository.promotion;

import com.example.demo.model.promotion.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IPromotionRepository  extends JpaRepository<Promotion,Integer> {
    @Query(value = "SELECT p FROM Promotion p WHERE p.isDelete=false ", nativeQuery = false)
    List<Promotion> findAll();

    @Query(value = "SELECT p FROM Promotion p WHERE p.id=?1 and p.isDelete=false", nativeQuery = false)
    Optional<Promotion> findById(Integer id);
}
