package com.example.demo.repository.movie;

import com.example.demo.model.movie.MovieAndType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovieAndTypeRepository extends JpaRepository<MovieAndType,Integer>{
}
