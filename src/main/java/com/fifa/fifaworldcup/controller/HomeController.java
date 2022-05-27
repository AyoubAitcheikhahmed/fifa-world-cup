package com.fifa.fifaworldcup.controller;

import com.fifa.fifaworldcup.entity.Competition;
import com.fifa.fifaworldcup.entity.CompetitionTicket;
import com.fifa.fifaworldcup.repository.CompetitionRepository;
import com.fifa.fifaworldcup.service.CompetitionService;
import com.fifa.fifaworldcup.service.CompetitionTicketService;
import com.fifa.fifaworldcup.service.StadiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private CompetitionService competitionService;
    private StadiumService stadiumService;
    private CompetitionTicketService competitionTicketService;

    public HomeController(CompetitionService competitionService, StadiumService stadiumService,CompetitionTicketService competitionTicketService) {
        this.competitionService = competitionService;
        this.stadiumService = stadiumService;
        this.competitionTicketService = competitionTicketService;
    }

    @GetMapping("/")
    public String index(
            @ModelAttribute("purchased_tickets_number") String purchased_tickets_number ,
            Model model
            ){
        model.addAttribute("stadiumList",stadiumService.getAllStadiums());
        String active_display;

        try{
            int nr = Integer.parseInt(purchased_tickets_number);
            if (nr >  0) {
                active_display= "true";
                model.addAttribute("purchased_tickets_number",purchased_tickets_number);
                model.addAttribute("active_display",active_display);
                nr= 0;
                active_display= "false";
            }
        }catch (NumberFormatException ex){
            active_display= "false";
            model.addAttribute("active_display",active_display);
        }


        return "fifa";
    }

    @PostMapping("/display_games")
    public String display_games(@RequestParam("stadium_name") String stadium_name, Model model){
        model.addAttribute("stadium",stadiumService.getStadiumByStadium(stadium_name));
        model.addAttribute("games",competitionService.getStadiumCompetitions(stadium_name));
        return "games_table";
    }

   @PostMapping("/purchase_ticket")
   public String purchase_ticket(@RequestParam("competition_id") Long competition_id, Model model){
       model.addAttribute("game",competitionService.getCompetition(competition_id));
       model.addAttribute("new_ticket", new CompetitionTicket());

       return "purchase_ticket";
   }

   @PostMapping("/proceed_ticket")
    public String proceed_ticket(
            @Valid @ModelAttribute("new_ticket")CompetitionTicket current_ticket,
            BindingResult theBindingResult,
            @RequestParam("game_id_ticket") Long game_id_ticket,
            Model model,
            Errors errors,
            RedirectAttributes redirectAttributest){

        if(errors.hasErrors()) {
            System.out.println("ERRORS >>>>> : "+errors);
            model.addAttribute("game",competitionService.getCompetition(game_id_ticket));
            return "purchase_ticket";
        }
//        }else{
//        //save new ticket
//        competitionTicketService.save(current_ticket);
//
//
//
//       //Update entitiy
//        int available_tickets = competitionService.getCompetition(game_id_ticket).buyTicket(current_ticket.getTicket());
//
//        //send new changes to REPO
//        competitionService.updateAndSave(available_tickets,competitionService.getCompetition(game_id_ticket).getId());
//        redirectAttributest.addAttribute("purchased_tickets_number",current_ticket.getTickets());
//
//       return "redirect:/";
//          }
            return "purchase_ticket";}

}


/*
Attribute th:field will replace attributes value, id and name in your input tag.
Instead, use plain th:id, th:value and th:name without using th:field. Then you will get what you wanted.
 */