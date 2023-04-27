package com.example.demo.service.promotion;

import com.example.demo.model.promotion.Promotion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPromotionService {
    List<Promotion> findAll();

    Promotion findById(Integer id);
}
