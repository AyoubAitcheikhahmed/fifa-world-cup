package com.fifa.fifaworldcup;

import com.fifa.fifaworldcup.entity.Competition;
import com.fifa.fifaworldcup.entity.Stadium;
import com.fifa.fifaworldcup.repository.CompetitionRepository;
import com.fifa.fifaworldcup.repository.StadiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class FifaWorldCupApplication    implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(FifaWorldCupApplication.class, args);
    }


    @Autowired
    CompetitionRepository competitionRepository;
    @Autowired
    StadiumRepository stadiumRepository;
    @Override
    public void run(String... args) throws Exception {
        //public Competition(List<String> countries, Date day, String stadium, Date hour) {
        List<String> countries1 = new ArrayList<>();
        Collections.addAll(countries1,"Belgium","Canada");
        List<String> countries2 = new ArrayList<>();
        Collections.addAll(countries2,"Brazil","Switzerland");
        List<String> countries3 = new ArrayList<>();
        Collections.addAll(countries3,"Morocco","Croatia");
        List<String> countries4 = new ArrayList<>();
        Collections.addAll(countries4,"Argentine","Mexico");
        List<String> countries5 = new ArrayList<>();
        Collections.addAll(countries5,"England","USA");



        LocalDate date1 = LocalDate.of(2022,11,26);
        LocalTime time1 = LocalTime.of(21,00);


        LocalDate date2= LocalDate.of(2022,11,27);
        LocalTime time2 = LocalTime.of(18,00);

        LocalDate date3 = LocalDate.of(2022,11,28);
        LocalTime time3 = LocalTime.of(21,00);

        LocalDate date4 = LocalDate.of(2022,11,29);
        LocalTime time4 = LocalTime.of(21,00);

        LocalDate date5 = LocalDate.of(2022,11,30);
        LocalTime time5 = LocalTime.of(21,00);

        Competition game1 = new Competition(countries1,date1, time1,"AL BAYT",31);
        Competition game2 = new Competition(countries2,date2,time2,"AL BAYT",45);
        Competition game3 = new Competition(countries3,date3,time3,"AL BAYT",44);
        Competition game4 = new Competition(countries4,date4,time4,"AL BAYT",8);
        Competition game5 = new Competition(countries5,date5,time5,"AL BAYT",45);





        competitionRepository.save(game1);
        competitionRepository.save(game2);
        competitionRepository.save(game3);
        competitionRepository.save(game4);
        competitionRepository.save(game5);


        Stadium s1 = new Stadium("AL THUMAMA");
        Stadium s2 = new Stadium("AL BAYT");
        Stadium s3 = new Stadium("Lusail");
        Stadium s4 = new Stadium("Al Janoub");
        List <Stadium> stadiums= new ArrayList<>();

        Collections.addAll(stadiums,s1,s2,s3,s4);
        stadiumRepository.saveAll(stadiums);
    }
}
