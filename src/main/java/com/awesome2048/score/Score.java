package com.awesome2048.score;

import javax.persistence.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = ScoreSerializer.class)
@Entity
@Table(name = "scores")
public class Score {

    private static final long serialVersionUID = -3009157732242241606L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "score", nullable = false)
    private int score;

    @Column(name = "country_code", columnDefinition = "bpchar(2)", nullable = false)
    private String countryCode;

    public Score(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public Score() {}

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
