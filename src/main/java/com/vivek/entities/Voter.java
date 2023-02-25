package com.vivek.entities;


import javax.persistence.*;


@Entity
@Table(name="voter_info")
public class Voter {
    @Id
    @Column(name="voter_id")
    private int id;
    private  String name;
    private Gender gender;

    //Here need to match mappedBy with variable name in Vote class.
    @OneToOne(mappedBy = "voteFKID")
    private Vote vote;

    public Voter() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Vote getVote() {
        return vote;
    }

    public void setVote(Vote vote) {
        this.vote = vote;
    }
}
