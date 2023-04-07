package com.dh.movieservice.api.controller;

import com.dh.movieservice.api.service.MovieService;
import com.dh.movieservice.api.service.queue.MovieSender;
import com.dh.movieservice.domain.model.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RefreshScope
@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    private final MovieService service;

    private final MovieSender movieSender;


    @GetMapping("/{genre}")
    ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre) {
        return ResponseEntity.ok().body(service.findByGenre(genre));
    }

    @PostMapping("/save")
    ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {

        Movie movieSaved = service.save(movie);
        movieSender.send(movieSaved);

        return ResponseEntity.ok().body(movieSaved);
    }
}
