package com.fifa.fifaworldcup.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "game_ticket")
public class CompetitionTicket {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ticket", nullable = false)
    private Long id;

    @NotNull(message = "This field is required")
    @Email(regexp = "^(.+)@(.+)$", message = "Invalid email pattern")
    @Column(name = "email")
    private String email;

    @Column(name = "game_id_game",nullable=false)
    private Long game_id_ticket;

    @NotNull(message = "This field is required")
    @Min(value = 1,  message = "Code 1 should be between 1 and 25 ")
    @Column(name = "code1")
    private int code1;

    @Min(value = 1, message = "Code 2 should be between 1 and 25")
    @Column(name = "code2")
    private int code2;

    @Min(value = 1, message = "Number of tickets should be greather than 0")
    @Column(name="purchased_tickets")
    private int tickets;
    public CompetitionTicket() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCode1() {
        return code1;
    }

    public void setCode1(int code1) {
        this.code1 = code1;
    }

    public int getCode2() {
        return code2;
    }

    public void setCode2(int code2) {
        this.code2 = code2;
    }

    public int getTickets() {
        return tickets;
    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
    }

    public Long getGame_id_ticket() {
        return game_id_ticket;
    }

    public void setGame_id_ticket(Long game_id_ticket) {
        this.game_id_ticket = game_id_ticket;
    }

    public int getTicket() {
        return tickets;
    }

    public void setTicket(int tickets) {
        this.tickets = tickets;
    }
}
