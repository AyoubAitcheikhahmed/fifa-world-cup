package com.fifa.fifaworldcup.entity;

import com.vladmihalcea.hibernate.type.array.StringArrayType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.lang.reflect.Array;
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

    @Temporal(TemporalType.DATE)
    @Column(name="game_day")
    private Date day;

    @Column(name="stadium_name")
    private String stadium;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="game_hour")
    private Date hour;


    public Competition() {

    }

    public Competition(List<String> countries, Date day, String stadium, Date hour) {
        this.countries = countries;
        this.day = day;
        this.stadium = stadium;
        this.hour = hour;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Date getHour() {
        return hour;
    }

    public void setHour(Date hour) {
        this.hour = hour;
    }



}
