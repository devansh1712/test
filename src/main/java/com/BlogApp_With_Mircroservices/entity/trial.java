package com.BlogApp_With_Mircroservices.entity;

import lombok.Data;

import javax.persistence.*;



@Entity
@Data
@Table(name ="comments")

public class trial {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String name;
    private  String Email;

    @ManyToOne()
    @JoinColumn(name="post_id")
    private Post post;


}
