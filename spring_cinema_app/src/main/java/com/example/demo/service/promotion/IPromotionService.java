package com.example.demo.service.promotion;

import com.example.demo.model.promotion.PromotionV02;

import java.util.List;

public interface IPromotionService {
    List<PromotionV02> findAll();

    PromotionV02 findById(Integer id);
}
