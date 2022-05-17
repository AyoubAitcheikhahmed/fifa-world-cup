package com.fifa.fifaworldcup.service.Impl;

import com.fifa.fifaworldcup.entity.Stadium;
import com.fifa.fifaworldcup.repository.StadiumRepository;
import com.fifa.fifaworldcup.service.StadiumService;

import java.util.List;

public class StadiumServiceImpl implements StadiumService {

    private StadiumRepository stadiumRepository;

    public StadiumServiceImpl(StadiumRepository stadiumRepository) {
        this.stadiumRepository = stadiumRepository;
    }

    @Override
    public List<Stadium> getAllStadiums() {
        return stadiumRepository.findAll();
    }
}
