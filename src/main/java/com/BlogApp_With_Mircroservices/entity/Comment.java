package com.BlogApp_With_Mircroservices.entity;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name ="comments")

public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String name;
    private  String Email;

    @ManyToOne()
    @JoinColumn(name="post_id")
    private Post post;


}
