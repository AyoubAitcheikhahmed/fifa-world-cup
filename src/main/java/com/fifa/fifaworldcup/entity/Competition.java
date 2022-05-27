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
    private int availableTickets;


    public Competition() {

    }

    public Competition(List<String> countries, LocalDate date,LocalTime hour, String stadium,int availableTickets ) {

        this.countries = countries;
        this.date = date;
        this.hour = hour;
        this.stadium = stadium;
        this.availableTickets = availableTickets;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int buyTicket(int tickets_number) {
        System.out.println("TICKET NUMBER "+tickets_number);

        if (tickets_number <= 0) {
            return -1;
        }

        //tickets available
        if (availableTickets >= tickets_number) {
            this.availableTickets = this.availableTickets - tickets_number;
            System.out.println("AVAILABLE TICKETs " + this.availableTickets);
            return availableTickets;
        }else{return 0;}

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

    public int getAvailableTickets() {
        return availableTickets;
    }

    public void setAvailableTickets(int availableTickets) {
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
