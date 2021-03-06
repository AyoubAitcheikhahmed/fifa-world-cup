package com.fifa.fifaworldcup.repository;

import com.fifa.fifaworldcup.entity.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StadiumRepository extends JpaRepository<Stadium,Long> {
    Stadium findStadiumByStadium(String stadium_name);
}
