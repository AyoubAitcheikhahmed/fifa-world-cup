package com.fifa.fifaworldcup.service.Impl;

import com.fifa.fifaworldcup.entity.CompetitionTicket;
import com.fifa.fifaworldcup.repository.CompetitionTicketRepository;
import com.fifa.fifaworldcup.service.CompetitionTicketService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetitionTicketServiceImpl implements CompetitionTicketService {
    private CompetitionTicketRepository competitionTicketRepository;

    public CompetitionTicketServiceImpl(CompetitionTicketRepository competitionTicketRepository) {
        this.competitionTicketRepository = competitionTicketRepository;
    }

    @Override
    public CompetitionTicket getCompetitionTicket(Long id_ticket) {
        return competitionTicketRepository.getById(id_ticket);
    }

    @Override
    public List<CompetitionTicket> getAllCompetitionTickets() {
        return competitionTicketRepository.findAll();
    }

    @Override
    public void save(CompetitionTicket ticket) {
        competitionTicketRepository.save(ticket);
    }
}
