package com.dh.catalogservice.domain.fallbacks;

import com.dh.catalogservice.domain.feign.IMovieRepository;
import com.dh.catalogservice.domain.model.Movie;
import com.dh.catalogservice.domain.offline.IMovieOfflineRepository;
import com.dh.catalogservice.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class MovieRepositoryFallback implements IMovieRepository {


    private final IMovieOfflineRepository movieOfflineRepository;

    @Override
    public ResponseEntity<List<Movie>> getMovieByGenre(String genre) {
        List<Movie> listMovies = movieOfflineRepository.findAllByGenre(genre);
        return ResponseEntity.ok(listMovies);
    }
}
