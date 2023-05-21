package com.example.demo.repository.movie;

import com.example.demo.model.movie.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, Integer> {
    /*
    * KhaiN admin movie-list-delete
    *
    * */


    @Query(value = "select * from movie where name like concat ('%',:name,'%') and start_day between :dateBegin and :dateEnd " +
        "and time_amount between :timeBegin and :timeEnd ", nativeQuery = true)
    List<Movie> findAllByNameContainingAndAndStartDayBetweenAndTimeAmountBetween(
          @Param("name")  String name,
          @Param("dateBegin") String dateBegin,
          @Param("dateEnd") String dateEnd,
          @Param("timeBegin")String timeBegin,
          @Param("timeEnd") String timeEnd);

    @Modifying
    @Transactional
    @Query("update Movie  m set m.isDelete = true where m.id = :id")
    Integer updateIsDeleteById(@Param("id") Integer id);
}
