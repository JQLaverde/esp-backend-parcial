package com.dh.catalogservice.domain.model;

import java.util.List;

public record Serie(String id, String name, String genre, List<SeasonDTO> seasons) {

    record SeasonDTO(Integer seasonNumber, List<ChapterDTO> chapters){

        record ChapterDTO(String name, Integer number, String urlStream){

        }
    }
}