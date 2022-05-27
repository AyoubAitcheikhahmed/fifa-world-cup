package com.fifa.fifaworldcup.service;

import com.fifa.fifaworldcup.entity.Competition;
import com.fifa.fifaworldcup.entity.Stadium;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CompetitionService {

    List<Competition> getAllCompetitions();
    Competition getCompetition(Long competition_id);
    List<Competition> getStadiumCompetitions(String stadium_name);

    void updateAndSave(int new_number,Long ticket_id);

}
