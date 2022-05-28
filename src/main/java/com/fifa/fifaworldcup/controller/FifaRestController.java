package com.fifa.fifaworldcup.controller;


import com.fifa.fifaworldcup.service.CompetitionService;
import com.fifa.fifaworldcup.service.CompetitionTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fifaDetail")
public class FifaRestController {

    @Autowired
    private CompetitionService competitionService;


    @RequestMapping("/{id}")
    public List<String> read(@PathVariable Long id){
        return competitionService.getCompetition(id).getCountries();
    }

}
