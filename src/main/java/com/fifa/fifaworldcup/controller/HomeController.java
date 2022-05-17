package com.fifa.fifaworldcup.controller;

import com.fifa.fifaworldcup.entity.Competition;
import com.fifa.fifaworldcup.repository.CompetitionRepository;
import com.fifa.fifaworldcup.service.CompetitionService;
import com.fifa.fifaworldcup.service.StadiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private CompetitionService competitionService;
    private StadiumService stadiumService;

    public HomeController(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("stadiumList",stadiumService.getAllStadiums());
        return "fifa";
    }
}
