package com.tasks.appwithspringboot.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "university_groups")
@Getter
@Setter
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column (name = "group_number")
    private String groupNumber;

    @OneToMany(mappedBy = "group")
    private List <Student> students;

   }
