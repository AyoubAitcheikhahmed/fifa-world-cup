package com.fifa.fifaworldcup.service.Impl;

import com.fifa.fifaworldcup.entity.Competition;
import com.fifa.fifaworldcup.repository.CompetitionRepository;
import com.fifa.fifaworldcup.service.CompetitionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompetitionServiceImpl implements CompetitionService {

    private CompetitionRepository competitionRepository;

    public CompetitionServiceImpl(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }

    @Override
    public List<Competition> getAllCompetitions() {
        return competitionRepository.findAll();
    }

    @Override
    public Competition getCompetition(Long competition_id) {
        return competitionRepository.getById(competition_id);
    }

    @Override
    public List<Competition> getStadiumCompetitions(String stadium_name) {
        return competitionRepository.findByStadium(stadium_name);

    }

    @Override
    @Transactional
    public void updateAndSave(int new_number,Long ticket_id) {
        competitionRepository.setAvailableTickets(new_number,ticket_id);
    }

}
