package com.fifa.fifaworldcup.entity;
import javax.persistence.*;

@Entity
public class Stadium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_stadium",nullable = false)
    private Long id;

    @Column(name = "stadium_name")
    private String stadium;

    public Stadium(String stadium) {
        this.stadium = stadium;
    }

    public Stadium() {
    }

    public String getStadium() {
        return stadium;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }
}
