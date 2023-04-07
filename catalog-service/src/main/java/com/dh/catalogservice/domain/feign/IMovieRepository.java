package com.dh.catalogservice.domain.feign;

import com.dh.catalogservice.domain.fallbacks.MovieRepositoryFallback;
import com.dh.catalogservice.domain.model.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="movie-service", fallback = MovieRepositoryFallback.class)
public interface IMovieRepository {

    @GetMapping("/api/v1/movies/{genre}")
    ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre);
}
