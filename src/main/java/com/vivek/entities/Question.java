package com.vivek.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="questions")
public class Question {

    @Id
    @Column(name="question_id")
    private int id;

    @Column(name="question")
    private  String ques;

    @OneToMany(mappedBy="question", cascade = CascadeType.ALL)
    List<Answer> answerList;

    public Question() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQues() {
        return ques;
    }

    public void setQues(String ques) {
        this.ques = ques;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", ques='" + ques + '\'' +
                ", answerList=" + answerList +
                '}';
    }
}
