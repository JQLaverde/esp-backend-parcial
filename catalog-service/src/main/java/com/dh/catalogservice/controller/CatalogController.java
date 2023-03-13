package com.dh.catalogservice.controller;

import com.dh.catalogservice.domain.model.Movie;
import com.dh.catalogservice.service.ICatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    private  ICatalogService catalogService;

    @GetMapping("/{genre}")
    ResponseEntity<List<Movie>> getGenre(@PathVariable String genre) {
        return ResponseEntity.ok(catalogService.getMovieByGenre(genre));
    }

}
