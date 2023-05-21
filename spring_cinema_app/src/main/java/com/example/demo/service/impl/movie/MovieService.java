package com.example.demo.service.impl.movie;


import com.example.demo.dto.movie.MovieViewDTO;
import com.example.demo.error.NotFoundById;
import com.example.demo.model.movie.Movie;
import com.example.demo.repository.movie.IMovieRepository;
import com.example.demo.service.movie.IMovieService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.time.LocalDate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class MovieService implements IMovieService {
    @Autowired
    IMovieRepository repository;

//    @Override
//    public Page<MovieViewDTO> findAll(Pageable pageable) {
//        return repository.findAll(pageable).map(MovieViewDTO::new);
//    }

    @Override
    public Page<MovieViewDTO> findAllByNameAndByStartDayAndByTimeAmount(String name, String startDay, String timeAmount, String studios, Pageable pageable) {
       String beginDateValue = startDay.equals("") ?  "1000-10-10 00:00:00": LocalDate.now().toString().concat(" 00:00:00");
        String endDayValue = startDay.equals("") ? "3000-10-10 00:00:00" : LocalDate.now().plusDays(Integer.parseInt(startDay)).toString().concat(" 00:00:00");
        String timeBegin = (timeAmount.equals("") || timeAmount.equals("60")) ? "0" : timeAmount.equals("90") ? "60" : "120";
        String timeEnd = timeAmount.equals("") ? "999999" : timeAmount.equals("60") ? "60" : timeAmount.equals("90") ? "120" : "999999";
        List<MovieViewDTO> movieViewDTOS = repository
                .findAllByNameContainingAndAndStartDayBetweenAndTimeAmountBetween(name,beginDateValue , endDayValue, timeBegin, timeEnd)
                .stream()
                .map(MovieViewDTO::new)
                .collect(Collectors.toList());
          int toIndex = Math.min((pageable.getPageNumber() + 1) * pageable.getPageSize(),
                movieViewDTOS.size());
          int fromIndex = Math.max(toIndex - pageable.getPageSize(), 0);
        if ("".equalsIgnoreCase(studios)) {
            return new PageImpl<>(movieViewDTOS.subList(fromIndex,toIndex), pageable, movieViewDTOS.size());
        }
        List<MovieViewDTO> viewDTOS = movieViewDTOS
                .stream()
                .filter(x -> x.getMovieStudio().toLowerCase().contains(studios.toLowerCase()))
                .collect(Collectors.toList());
        toIndex = Math.min((pageable.getPageNumber() + 1) * pageable.getPageSize(),
                viewDTOS.size());
        return new PageImpl<>(viewDTOS.subList(fromIndex,toIndex), pageable, viewDTOS.size());
    }

    @Override
    @SneakyThrows
    public Movie findById(Integer id) throws NotFoundById {
        Optional<Movie> movie = repository.findById(id);
        if (movie.isPresent()) {
            return (movie.get());
        }
        throw new NotFoundById("Không tìm thấy bất kì phim nào có mã số: " + id);
    }

    @Override
    public Integer updateIsDeleteById(Integer id) {
        return repository.updateIsDeleteById(id);
    }
}
