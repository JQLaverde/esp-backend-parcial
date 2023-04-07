package com.dh.catalogservice.domain.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document(collection = "Series")
public record Serie(String id, String name, String genre, List<SeasonDTO> seasons) {

    record SeasonDTO(Integer seasonNumber, List<ChapterDTO> chapters){

        record ChapterDTO(String name, Integer number, String urlStream){

        }
    }
}