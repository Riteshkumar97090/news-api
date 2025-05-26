package com.codingage.newsapiinjava.service;

import com.codingage.newsapiinjava.model.NewsModel;

import java.util.List;
import java.util.Optional;

public interface NewsService {

    List<NewsModel> getAllNews();

    Optional<NewsModel> getNewsById(String id);

    NewsModel createNews(NewsModel news);

    NewsModel updateNews(String id, NewsModel newsDetails);

    void deleteNews(String id);

    List<NewsModel> searchNews(String query);
    List<NewsModel> getNewsByCategory(String category);

}


