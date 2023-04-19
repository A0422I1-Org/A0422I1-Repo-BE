package com.example.demo.repository.movie;

import com.example.demo.model.movie.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovieRepository  extends JpaRepository<Movie,Integer> {
    @Query("select m.id, m.image, m.name, m.startDay, m.status, m.timeAmount, mt.movieType.name " +
            "from Movie m join MovieAndType mt on m.id = mt.movieT.id where m.isDelete = false and m.status = '1'")
    Iterable<?> findOnShowingMovie();

    @Query("select m.id, m.image, m.name, m.startDay, m.status, m.timeAmount, mt.movieType.name " +
            "from Movie m join MovieAndType mt on m.id = mt.movieT.id where m.isDelete = false and m.status = '0'")
    Iterable<?> findUpcomingMovie();

    @Query("select m.id, m.image, m.name, m.startDay, m.status, m.timeAmount, mt.movieType.name " +
            "from Movie m join MovieAndType mt on m.id = mt.movieT.id where m.isDelete = false and m.name like %?1%")
    Iterable<?> findMovieByName(String name);
}
