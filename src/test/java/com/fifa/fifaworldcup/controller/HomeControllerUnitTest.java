package com.fifa.fifaworldcup.controller;

import com.fifa.fifaworldcup.entity.Competition;
import com.fifa.fifaworldcup.entity.CompetitionTicket;
import com.fifa.fifaworldcup.repository.StadiumRepository;
import com.fifa.fifaworldcup.service.CompetitionService;
import com.fifa.fifaworldcup.service.CompetitionTicketService;
import com.fifa.fifaworldcup.service.Impl.StadiumServiceImpl;
import com.fifa.fifaworldcup.service.StadiumService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static org.junit.jupiter.api.Assertions.*;

class HomeControllerUnitTest {

    @BeforeEach
    void init(){

    }

    @Test
    void shouldDirectToIndex() {

        Model model = Mockito.mock(Model.class);
        StadiumService stadiumService = Mockito.mock(StadiumService.class);
        CompetitionService competitionService = Mockito.mock(CompetitionService.class);
        CompetitionTicketService competitionTicketService = Mockito.mock(CompetitionTicketService.class);

        HomeController homeController = new HomeController(competitionService,stadiumService,competitionTicketService);
//        assertEquals("fifa",homeController.index("5",model));

    }

    @Test
    void shouldDisplayGames() {

        Model model = Mockito.mock(Model.class);
        StadiumService stadiumService = Mockito.mock(StadiumService.class);
        CompetitionService competitionService = Mockito.mock(CompetitionService.class);
        CompetitionTicketService competitionTicketService = Mockito.mock(CompetitionTicketService.class);

        HomeController homeController = new HomeController(competitionService,stadiumService,competitionTicketService);
        assertEquals("games_table",homeController.display_games("AL BAYT",model));
    }

    @Test
    void purchase_ticket() {
        Model model = Mockito.mock(Model.class);
        StadiumService stadiumService = Mockito.mock(StadiumService.class);
        CompetitionService competitionService = Mockito.mock(CompetitionService.class);
        CompetitionTicketService competitionTicketService = Mockito.mock(CompetitionTicketService.class);

        HomeController homeController = new HomeController(competitionService,stadiumService,competitionTicketService);

        assertEquals("purchase_ticket",homeController.purchase_ticket(Long.getLong("42"),model));
    }

    @Test
    void proceed_ticket() {
        Model model = Mockito.mock(Model.class);
        StadiumService stadiumService = Mockito.mock(StadiumService.class);
        CompetitionService competitionService = Mockito.mock(CompetitionService.class);
        CompetitionTicketService competitionTicketService = Mockito.mock(CompetitionTicketService.class);

        CompetitionTicket ticket = Mockito.mock(CompetitionTicket.class);
        Errors errors = Mockito.mock(Errors.class);
        RedirectAttributes redirectAttributes = Mockito.mock(RedirectAttributes.class);


        HomeController homeController = new HomeController(competitionService,stadiumService,competitionTicketService);

        assertEquals("purchase_ticket",homeController.proceed_ticket(ticket,Long.getLong("34"),model,errors,redirectAttributes));
    }
}