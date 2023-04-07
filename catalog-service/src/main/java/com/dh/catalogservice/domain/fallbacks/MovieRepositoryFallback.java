package com.dh.catalogservice.domain.fallbacks;

import com.dh.catalogservice.domain.feign.IMovieRepository;
import com.dh.catalogservice.domain.model.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieRepositoryFallback implements IMovieRepository {
    @Override
    public ResponseEntity<List<Movie>> getMovieByGenre(String genre) {
        //
        return ResponseEntity.ok(List.of(new Movie(-1L, "Vacio", "Vacio", "Vacio")));
    }
}
