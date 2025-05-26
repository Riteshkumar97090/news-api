package com.codingage.newsapiinjava.controller;

import com.codingage.newsapiinjava.model.NewsModel;
import com.codingage.newsapiinjava.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/news")
@CrossOrigin(origins = "*")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping
    public List<NewsModel> getAllNews() {
        return newsService.getAllNews();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewsModel> getNewsById(@PathVariable String id) {
        Optional<NewsModel> newsOpt = newsService.getNewsById(id);
        if (newsOpt.isPresent()) {
            return ResponseEntity.ok(newsOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public NewsModel createNews(@RequestBody NewsModel news) {
        return newsService.createNews(news);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NewsModel> updateNews(@PathVariable String id, @RequestBody NewsModel newsDetails) {
        NewsModel updatedNews = newsService.updateNews(id, newsDetails);
        return ResponseEntity.ok(updatedNews);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNews(@PathVariable String id) {
        newsService.deleteNews(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/search")
    public List<NewsModel> searchNews(@RequestParam String query) {
        return newsService.searchNews(query);
    }
    @GetMapping("/category/{category}")
    public List<NewsModel> getNewsByCategory(@PathVariable String category) {
        return newsService.getNewsByCategory(category);
    }

}
