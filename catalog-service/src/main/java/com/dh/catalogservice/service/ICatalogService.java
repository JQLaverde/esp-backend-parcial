package com.dh.catalogservice.service;

import com.dh.catalogservice.domain.model.Movie;
import com.dh.catalogservice.domain.model.Serie;

import java.util.List;
import java.util.Map;

public interface ICatalogService {
    Map<String, List<?>> getMovieAndSeriesByGenre (String genre);
    Map<String, List<?>> getOfflineMovieAndSeriesByGenre (String genre);
    List<Serie> getOfflineSeriesByGenre(String genre);
    List<Movie> getOfflineMoviesByGenre(String genre);
    Serie createSerie(Serie serie);
    Movie createMovie(Movie movie);
}
