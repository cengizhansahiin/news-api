package tr.com.id3.news.newsapi.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tr.com.id3.news.newsapi.model.Article;
import tr.com.id3.news.newsapi.model.ArticleDTO;
import tr.com.id3.news.newsapi.service.NewsControllerService;

import java.util.List;

@RestController
@Slf4j
public class NewsController {
    @Autowired
    NewsControllerService newsControllerService;

    @GetMapping("/getNews")
    public List<Article> getAllNews(){
        return newsControllerService.getAllNews();
    }
    @DeleteMapping("/deleteNews")
    public void deleteAllNews(){
        newsControllerService.deleteAllNews();
    }
    @GetMapping("/getNews/{id}")
    public Article getNewsById(@PathVariable("id") int id){
        return newsControllerService.getNewsById(id);
    }
    @DeleteMapping("/deleteNews/{id}")
    public void deleteNewsById(@PathVariable("id") int id){
        newsControllerService.deleteNewsById(id);
    }
    @PostMapping("/createNews")
    public void createNews(@RequestBody ArticleDTO articleDTO){
        newsControllerService.createNews(articleDTO);
    }
    @PutMapping("/updateNews")
    public void updateNewsById(@RequestBody Article article){
        newsControllerService.updateNews(article);
    }

}
