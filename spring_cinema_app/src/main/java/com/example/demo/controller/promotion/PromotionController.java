package com.example.demo.controller.promotion;

import com.example.demo.model.promotion.PromotionV02;
import com.example.demo.service.promotion.IPromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/public/promotion")
@CrossOrigin(origins = "http://localhost:4200")
public class PromotionController {
    @Autowired
    private IPromotionService iPromotionService;

    @GetMapping("/list")
    public ResponseEntity<List<PromotionV02>> getListPromotion() {
        return new ResponseEntity<>(iPromotionService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PromotionV02> getPromotionById(@PathVariable("id") Integer id) {
        PromotionV02 promotion = iPromotionService.findById(id);
        if (promotion == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(promotion, HttpStatus.OK);
    }
}
