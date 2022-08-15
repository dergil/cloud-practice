package com.github.dergil.postingproximityserver;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name="postings")
public class PostingSnippet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postingId;
    private Double longitude;
    private Double latitude;
    private String title;
    private String textSnippet;

}
