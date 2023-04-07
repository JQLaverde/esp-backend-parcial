package com.dh.catalogservice.service;

import com.dh.catalogservice.domain.model.Movie;

import java.util.List;
import java.util.Map;

public interface ICatalogService {
    Map<String, List<?>> getMovieAndSeriesByGenre (String genre);
}
