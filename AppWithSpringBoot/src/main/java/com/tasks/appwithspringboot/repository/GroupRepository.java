package com.tasks.appwithspringboot.repository;

import com.tasks.appwithspringboot.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {

    Group findGroupByGroupNumber(String number);

    List<Group> findAll ();

}
