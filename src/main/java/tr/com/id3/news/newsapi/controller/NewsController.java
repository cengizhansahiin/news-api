package tr.com.id3.news.newsapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tr.com.id3.news.newsapi.model.Article;
import tr.com.id3.news.newsapi.model.ArticleInDTO;
import tr.com.id3.news.newsapi.service.NewsControllerService;

import java.util.List;

@RestController
public class NewsController {
    @Autowired
    NewsControllerService newsControllerService;

    @RequestMapping(value = "/getAllNews",produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public List<Article> getAllNews(){
        return newsControllerService.getAllNews();
    }
    @RequestMapping(value = "deleteAllNews",produces = "application/json", method = RequestMethod.DELETE)
    public void deleteAllNews(){
        newsControllerService.deleteAllNews();
    }
    @RequestMapping(value = "/getNews/{id}",produces = "application/json", method = RequestMethod.GET)
    public Article getNewsById(@PathVariable("id") int id){
        return newsControllerService.getNewsById(id);
    }
    @RequestMapping(value = "/deleteNews/{id}",produces = "application/json",  method = RequestMethod.DELETE)
    public void deleteNewsById(@PathVariable("id") int id){
        newsControllerService.deleteNewsById(id);
    }
    @RequestMapping(value = "/createNews",produces = "application/json", method = RequestMethod.POST)
    public void createNews(ArticleInDTO articleInDTO){
        newsControllerService.createNews(articleInDTO);
    }
    @RequestMapping(value = "/updateNews/{id}",produces = "application/json", method = RequestMethod.PUT)
    public void updateNewsById(@PathVariable("id") int id,ArticleInDTO articleInDTO){
        newsControllerService.updateNewsById(id,articleInDTO);
    }

}
