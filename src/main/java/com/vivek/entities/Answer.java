package com.vivek.entities;

import javax.persistence.*;

@Entity
@Table(name="answers")
public class Answer {

    @Id
    @Column(name="answer_id")
    private int id;

    @Column(name="answer")
    private String ans;

    @ManyToOne
    @JoinColumn(name="question_fk_id")
    private Question question;

    public Answer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", ans='" + ans + '\'' +
                ", question=" + question +
                '}';
    }
}
