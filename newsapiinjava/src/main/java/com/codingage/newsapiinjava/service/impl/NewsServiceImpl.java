package com.codingage.newsapiinjava.service.impl;

import com.codingage.newsapiinjava.Repository.NewsRepository;
import com.codingage.newsapiinjava.model.NewsModel;
import com.codingage.newsapiinjava.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Override
    public List<NewsModel> getAllNews() {
        return newsRepository.findAll();
    }

    @Override
    public Optional<NewsModel> getNewsById(String id) {
        return newsRepository.findById(id);
    }


    @Override
    public NewsModel createNews(NewsModel news) {
        return newsRepository.save(news);
    }

    @Override
    public NewsModel updateNews(String id, NewsModel newsDetails) {
        return newsRepository.findById(id).map(news -> {
            news.setTitle(newsDetails.getTitle());
            news.setDescription(newsDetails.getDescription());
            news.setUrl(newsDetails.getUrl());
            news.setUrlToImage(newsDetails.getUrlToImage());
            news.setPublishedAt(newsDetails.getPublishedAt());
            news.setContent(newsDetails.getContent());
            news.setCategory(newsDetails.getCategory());
            news.setSearchQuery(newsDetails.getSearchQuery());
            news.setFetchedAt(newsDetails.getFetchedAt());
            return newsRepository.save(news);
        }).orElseGet(() -> {
            newsDetails.setId(id);
            return newsRepository.save(newsDetails);
        });
    }

    @Override
    public void deleteNews(String id) {
        newsRepository.deleteById(id);
    }

    @Override
    public List<NewsModel> searchNews(String query) {
        return newsRepository.findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(query, query);
    }

    @Override
    public List<NewsModel> getNewsByCategory(String category) {
        return newsRepository.findByCategoryIgnoreCase(category);
    }

}

