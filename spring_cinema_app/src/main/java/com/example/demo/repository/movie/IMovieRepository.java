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
    @Query(value = "select * from Movie where " +
            "name like concat('%',:name,'%') " +
            "and start_day like concat('%',:startDay,'%') " +
            "and time_amount like concat('%',:timeAmount,'%') and is_delete = 0",
            nativeQuery = true)
    Page<Movie> findAllByNameAndByStartDayAndByTimeAmount(@Param("name") String name,
                                                          @Param("startDay") String startDay,
                                                          @Param("timeAmount") String timeAmount,
                                                          Pageable page);

    @Query(value = "select * from Movie where " +
            "name like concat('%',:name,'%') " +
            "and start_day like concat('%',:startDay,'%') " +
            "and time_amount like concat('%',:timeAmount,'%') and is_delete = 0",
            nativeQuery = true)
    List<Movie> findAllByThreeCondition(@Param("name") String name,
                                        @Param("startDay") String startDay,
                                        @Param("timeAmount") String timeAmount);

    @Modifying
    @Transactional
    @Query("update Movie  m set m.isDelete = true where m.id = :id")
    Integer updateIsDeleteById(@Param("id") Integer id);
}
