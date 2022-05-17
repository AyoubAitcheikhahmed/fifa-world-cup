package com.fifa.fifaworldcup.repository;

import com.fifa.fifaworldcup.entity.Competition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetitionRepository extends JpaRepository<Competition,Long> {
}
