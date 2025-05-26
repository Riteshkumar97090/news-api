package com.codingage.newsapiinjava.Repository;

import com.codingage.newsapiinjava.model.NewsModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NewsRepository extends MongoRepository<NewsModel, String> {
    // Search ke liye
    List<NewsModel> findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String title, String description);

    // Category ke liye
    List<NewsModel> findByCategoryIgnoreCase(String category);


}
