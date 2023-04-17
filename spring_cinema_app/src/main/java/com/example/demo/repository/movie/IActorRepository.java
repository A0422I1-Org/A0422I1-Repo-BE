package com.example.demo.repository.movie;

import com.example.demo.model.movie.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;

@Repository
public interface IActorRepository extends JpaRepository<Actor,Integer>{
}
