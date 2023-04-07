package com.dh.catalogservice.service;

import com.dh.catalogservice.domain.feign.IMovieRepository;
import com.dh.catalogservice.domain.feign.ISerieRepository;
import com.dh.catalogservice.domain.model.Movie;
import com.dh.catalogservice.domain.model.Serie;
import com.dh.catalogservice.domain.offline.IMovieOfflineRepository;
import com.dh.catalogservice.domain.offline.ISerieOfflineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CatalogService  implements ICatalogService{

    @Autowired
    private IMovieRepository movieRepository;

    @Autowired
    private IMovieOfflineRepository movieOfflineRepository;

    @Autowired
    private ISerieRepository serieRepository;

    @Autowired
    private ISerieOfflineRepository serieOfflineRepository;


    @Override
    public Map<String, List<?>> getMovieAndSeriesByGenre(String genre) {

        ResponseEntity<List<Movie>> moviesResponse = movieRepository.getMovieByGenre(genre);
        ResponseEntity<List<Serie>> seriesReponse = serieRepository.getSerieByGenre(genre);

        Map<String, List<?>> response = new HashMap<>();
        response.put("movies", moviesResponse.getBody());
        response.put("series", seriesReponse.getBody());

         return response;
    }

    @Override
    public Map<String, List<?>> getOfflineMovieAndSeriesByGenre(String genre) {
        List<Movie> moviesResponse = movieOfflineRepository.findAllByGenre(genre);
        List<Serie> seriesReponse = serieOfflineRepository.findAllByGenre(genre);

        Map<String, List<?>> response = new HashMap<>();
        response.put("movies", moviesResponse);
        response.put("series", seriesReponse);

        return response;
    }

    @Override
    public List<Serie> getOfflineSeriesByGenre(String genre) {
        return serieOfflineRepository.findAllByGenre(genre);
    }

    @Override
    public List<Movie> getOfflineMoviesByGenre(String genre) {
        return movieOfflineRepository.findAllByGenre(genre);
    }

    @Override
    public Serie createSerie(Serie serie) {
        return serieOfflineRepository.save(serie);
    }

    @Override
    public Movie createMovie(Movie movie) {
        return movieOfflineRepository.save(movie);
    }
}
