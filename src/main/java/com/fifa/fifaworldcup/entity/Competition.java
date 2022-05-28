package com.fifa.fifaworldcup.entity;

import com.vladmihalcea.hibernate.type.array.StringArrayType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "game")
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_game", nullable = false)
    private Long id;

    @ElementCollection
    @Column(name="game_countries")
    private List<String> countries;

    @Column(name="game_date")
    private LocalDate date;

    @Column(name="game_hour")
    private LocalTime hour;


    @Column(name="stadium_name")
    private String stadium;

    @Column(name="nr_availableTickets")
    private Integer availableTickets;


    public Competition() {

    }

    public Competition(List<String> countries, LocalDate date,LocalTime hour, String stadium,Integer availableTickets ) {

        this.countries = countries;
        this.date = date;
        this.hour = hour;
        this.stadium = stadium;
        this.availableTickets = availableTickets;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer buyTicket(Integer tickets_number) {

        //WRONG TICKET INPUT >>> -1
        if (tickets_number <= 0) {
            return -1;
        }

        //TICKET NUMBER CORRED + TICKETS ARE AVAILABLE  TICKET INPUT >>> RETURN NUMBER OF TICKET BOUGHT
        if (availableTickets >= tickets_number) {
            this.availableTickets = this.availableTickets - tickets_number;
            return tickets_number;
        }else{
            System.out.println("inside return 0 available tickets is not enough ");
            //TICKETS ARE NOT AVAILABLE
            return 0;}

    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getHour() {
        return hour;
    }

    public void setHour(LocalTime hour) {
        this.hour = hour;
    }

    public Integer getAvailableTickets() {
        return availableTickets;
    }

    public void setAvailableTickets(Integer availableTickets) {
        this.availableTickets = availableTickets;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public Long getId() {
        return id;
    }
}
