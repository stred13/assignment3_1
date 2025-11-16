package com.example.assignment3_1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Table
@Entity
public class BookCopy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column
    Date publishDate;

    @Column
    Integer version;

    @JsonIgnore
    @ManyToOne
    Book book;

    public BookCopy(Date publishDate, Integer version){
        this.publishDate = publishDate;
        this.version = version;
    }

    public BookCopy(){}
}
