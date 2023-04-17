package com.example.demo.repository.movie;

import com.example.demo.model.movie.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IDirectorRepository extends JpaRepository<Director,Integer> {

    @Query( value = "SELECT * FROM theater_management_2.director where is_delete =0 and id = :id",nativeQuery = true)
    Optional<Director> findById(@Param("id") Integer id);
}
