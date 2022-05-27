package com.fifa.fifaworldcup.service.Impl;

import com.fifa.fifaworldcup.entity.Stadium;
import com.fifa.fifaworldcup.repository.StadiumRepository;
import com.fifa.fifaworldcup.service.StadiumService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StadiumServiceImpl implements StadiumService {

    private StadiumRepository stadiumRepository;

    public StadiumServiceImpl(StadiumRepository stadiumRepository) {
        this.stadiumRepository = stadiumRepository;
    }

    @Override
    public List<Stadium> getAllStadiums() {
        return stadiumRepository.findAll();
    }



    @Override
    public Stadium getStadiumByStadium(String stadium_name) {
        return stadiumRepository.findStadiumByStadium(stadium_name);
    }
}
