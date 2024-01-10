package com.tasks.appwithspringboot.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table (name = "students")
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "surname")
    private String surname;

    @ManyToOne
    @JoinColumn(name = "university_groups_id")
    private Group group;

}
