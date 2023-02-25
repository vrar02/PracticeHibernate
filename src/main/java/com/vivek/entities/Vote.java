package com.vivek.entities;

import javax.persistence.*;

@Entity
@Table(name="vote_info")
public class Vote {

    @Id
    @Column(name="vote_id")
    private int id;

    @Column(name="party_name")
    private String partyName;

    @Column(name="ward_name")
    private String wardName;

    @OneToOne
    @JoinColumn(name="temp_id")
    private Voter voteFKID;

    public Vote() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getWardName() {
        return wardName;
    }

    public void setWardName(String wardName) {
        this.wardName = wardName;
    }

    public Voter getVoter() {
        return voteFKID;
    }

    public void setVoter(Voter voter) {
        this.voteFKID = voter;
    }
}
