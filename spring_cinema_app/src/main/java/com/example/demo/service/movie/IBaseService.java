package com.example.demo.service.movie;

import java.util.List;
import java.util.Optional;

public interface IBaseService<E> {
    Optional<E> findById(Integer id);

    void save(E e);

}
