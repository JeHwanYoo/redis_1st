package com.movie.moviestorage.movie.repository;

import com.movie.moviedomain.movie.TheaterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TheaterRepositoryImpl implements TheaterRepository {

    private final TheaterJpaRepository theaterJpaRepository;

}
