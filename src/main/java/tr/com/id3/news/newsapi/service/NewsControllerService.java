package tr.com.id3.news.newsapi.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tr.com.id3.news.newsapi.mapper.ArticleMapper;
import tr.com.id3.news.newsapi.model.Article;
import tr.com.id3.news.newsapi.model.ArticleInDTO;
import tr.com.id3.news.newsapi.repository.ArticleRepository;

import java.sql.Date;
import java.util.List;


@Service
@Slf4j
@EnableJpaRepositories("tr.com.id3.news.newsapi.repository")
public class NewsControllerService {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ArticleMapper articleMapper;

    public void save(ArticleInDTO articleInDTO){
        articleRepository.save(articleMapper.dtoToArticle(articleInDTO));
        log.info(new ResponseEntity<>("Save News-> " + articleInDTO.toString(), HttpStatus.OK).toString());
    }
    public List<Article> getAllNews(){
        log.info(new ResponseEntity<>("Get All News -> " + articleRepository.findAll().toString(), HttpStatus.OK).toString());
        return articleRepository.findAll();
    }
    public void deleteAllNews(){
        articleRepository.deleteAll();
        log.info(new ResponseEntity<>("Delete All News", HttpStatus.OK).toString());
    }
    public Article getNewsById(int id){
        try {
            log.info(new ResponseEntity<>("Get News By Id ->" + articleRepository.findById(id).get().toString(), HttpStatus.OK).toString());
            return articleRepository.findById(id).get();
        }
        catch (Exception e){
            log.error("No such id.");
            return null;
        }
    }
    public void deleteNewsById(int id){
        try {
            articleRepository.deleteById(id);
            log.info(new ResponseEntity<>("Delete News By Id", HttpStatus.OK).toString());
        }
        catch (Exception e){
            log.error("No such id.");
        }
    }
    public void updateNewsById(int id, ArticleInDTO articleInDTO){
        try {
            Article article = articleMapper.dtoToArticle(articleInDTO);
            Article targetArticle = this.getNewsById(id);
            if (!article.getAuthor().equals("string")) targetArticle.setAuthor(article.getAuthor());
            if (!article.getTitle().equals("string")) targetArticle.setTitle(article.getTitle());
            if (!article.getDescription().equals("string")) targetArticle.setDescription(article.getDescription());
            if (!article.getUrl().equals("string")) targetArticle.setUrl(article.getUrl());
            if (!article.getUrlToImage().equals("string")) targetArticle.setUrlToImage(article.getUrlToImage());
            if (!article.getPublishedAt().equals("string")) targetArticle.setPublishedAt(article.getPublishedAt());
            if (!article.getContent().equals("string")) targetArticle.setContent(article.getContent());
            targetArticle.setUpdate_date(new Date(System.currentTimeMillis()));
            targetArticle.setId(id);
            articleRepository.deleteById(id);
            articleRepository.save(targetArticle);
            log.info(new ResponseEntity<>("Save News By Id-> " + articleInDTO.toString(), HttpStatus.OK).toString());

        }
        catch (Exception e){
            log.error("No such id.");
        }
    }
    public void createNews(ArticleInDTO articleInDTO){
        articleRepository.save(articleMapper.dtoToArticle(articleInDTO));
        log.info(new ResponseEntity<>("Create News-> " + articleInDTO.toString(), HttpStatus.OK).toString());
    }


}
