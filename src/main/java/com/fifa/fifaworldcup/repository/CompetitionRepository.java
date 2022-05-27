package com.fifa.fifaworldcup.repository;

import com.fifa.fifaworldcup.entity.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompetitionRepository extends JpaRepository<Competition,Long> {

//    @Query("SELECT t FROM Competition t WHERE t.stadium_name = ?1 ")
//    Competition findByStadium(String stadium_name);
//
    List<Competition> findByStadium(String stadium_name);

    @Modifying
    @Query("update Competition t set t.availableTickets = ?1 where t.id = ?2")
    int setAvailableTickets(Integer new_number, Long ticket_id);

}
