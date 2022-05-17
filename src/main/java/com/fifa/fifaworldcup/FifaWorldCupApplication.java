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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class FifaWorldCupApplication  implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(FifaWorldCupApplication.class, args);
    }

    @Autowired
    StadiumRepository stadiumRepository;

    @Override
    public void run(String... args) throws Exception {

        Stadium s1 = new Stadium("AL THUMAMA");
        Stadium s2 = new Stadium("AL BAYT");
        Stadium s3 = new Stadium("Lusail");
        Stadium s4 = new Stadium("Al Janoub");
        List <Stadium> stadiums= new ArrayList<>();

        Collections.addAll(stadiums,s1,s2,s3,s4);
        stadiumRepository.saveAll(stadiums);


    }
}
