package com.fifa.fifaworldcup.entity;

import javax.persistence.*;

@Entity
@Table(name = "game_ticket")
public class CompetitionTicket {
    @Id
    @Column(name = "id_ticket", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "game_id_game")
    private Competition game;

    @Column(name="tickets")
    private int tickets;

    public CompetitionTicket() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public int buyTicket(int number) {
        if (number <= 0) {
            return -1;
        }

        //tickets available
        if (tickets >= number) {
            tickets -= number;
            return number;
        }

        //tickets not available
        int bought = tickets;
        tickets = 0;
        return bought;
    }


    public Competition getGame() {
        return game;
    }

    public void setGame(Competition game) {
        this.game = game;
    }

    public int getTicket() {
        return tickets;
    }

    public void setTicket(int tickets) {
        this.tickets = tickets;
    }
}
