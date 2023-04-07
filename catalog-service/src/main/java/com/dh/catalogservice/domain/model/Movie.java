package com.dh.catalogservice.domain.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Movies")
public record Movie(Long id, String name, String genre, String urlStream) {
}
