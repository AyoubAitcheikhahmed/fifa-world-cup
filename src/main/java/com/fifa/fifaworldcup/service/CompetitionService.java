package com.fifa.fifaworldcup.service;

import com.fifa.fifaworldcup.entity.Competition;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CompetitionService {
    List<Competition> getAllCompetitions();

}
