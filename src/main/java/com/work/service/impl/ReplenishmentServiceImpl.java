package com.work.service.impl;

import com.work.entity.Replenishment;
import com.work.repository.ReplenishmentRepository;
import com.work.service.ReplenishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReplenishmentServiceImpl implements ReplenishmentService {
    @Autowired
    private ReplenishmentRepository replenishmentRepository;

    @Override
    public List<Replenishment> getAllReplenishments() {
        return replenishmentRepository.findAll();
    }
}
