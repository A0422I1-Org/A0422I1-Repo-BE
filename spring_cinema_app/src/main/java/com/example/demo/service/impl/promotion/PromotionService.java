package com.example.demo.service.impl.promotion;

import com.example.demo.model.promotion.Promotion;
import com.example.demo.repository.promotion.IPromotionRepository;
import com.example.demo.service.promotion.IPromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PromotionService implements IPromotionService {
    @Autowired
    private IPromotionRepository iPromotionRepository;

    @Override
    public List<Promotion> findAll() {
        return iPromotionRepository.findAll();
    }

    @Override
    public Promotion findById(Integer id) {
        return iPromotionRepository.findById(id).orElse(null);
    }
}
