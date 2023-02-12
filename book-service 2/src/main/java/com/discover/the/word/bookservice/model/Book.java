package com.discover.the.word.bookservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "app_book")
public class Book extends AbstractEntity {

        private String title;
        private Integer bookYear;
        private String author;
        private String pressName;
        private String isbn;
}