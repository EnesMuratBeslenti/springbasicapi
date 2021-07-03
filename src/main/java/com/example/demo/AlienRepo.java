package com.example.demo;

import com.example.demo.model.Alien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;//Normal Format extends CrudRepository update

public interface AlienRepo extends JpaRepository<Alien ,Integer> {


}
