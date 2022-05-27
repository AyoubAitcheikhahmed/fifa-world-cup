package com.fifa.fifaworldcup.service;

import com.fifa.fifaworldcup.entity.CompetitionTicket;

import java.util.List;

public interface CompetitionTicketService {
    CompetitionTicket getCompetitionTicket(Long id_ticket);
    List<CompetitionTicket> getAllCompetitionTickets();
    void save(CompetitionTicket ticket);
}
