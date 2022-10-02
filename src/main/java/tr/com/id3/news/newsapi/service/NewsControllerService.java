package tr.com.id3.news.newsapi.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tr.com.id3.news.newsapi.mapper.ArticleMapper;
import tr.com.id3.news.newsapi.model.Article;
import tr.com.id3.news.newsapi.model.ArticleDTO;
import tr.com.id3.news.newsapi.repository.ArticleRepository;

import java.util.List;


@Service
@Slf4j
@EnableJpaRepositories("tr.com.id3.news.newsapi.repository")
public class NewsControllerService {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ArticleMapper articleMapper;

    public List<Article> getAllNews(){
        log.info(new ResponseEntity<List<Article>>(articleRepository.findAll(), HttpStatus.OK).toString());
        return articleRepository.findAll();
    }
    public void deleteAllNews(){
        articleRepository.deleteAll();
        log.info(new ResponseEntity<>("Delete All News", HttpStatus.OK).toString());
    }
    public Article getNewsById(int id){
            log.info(new ResponseEntity<Article>(articleRepository.findById(id).get(), HttpStatus.OK).toString());
            return articleRepository.findById(id).get();
    }
    public void deleteNewsById(int id){
        try {
            articleRepository.deleteById(id);
            log.info(new ResponseEntity<>("Delete News By Id", HttpStatus.OK).toString());
        }
        catch (Exception e){
            log.error("No such id. (Delete)");
        }
    }
    public Article updateNews(Article article){
        log.info(new ResponseEntity<Article>(article,HttpStatus.OK).toString());
        return articleRepository.save(article);
    }
    public void createNews(ArticleDTO articleDTO){
        articleRepository.save(articleMapper.dtoToArticle(articleDTO));
        log.info(new ResponseEntity<ArticleDTO>(articleDTO, HttpStatus.CREATED).toString());
    }


}
