package com.optimagrowth.license.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name="postings")
public class Posting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postingId;
    private Float longitude;
    private Float latitude;
    private String title;
    private String text;
    private String textSnippet;
    private Boolean contactable;

}
