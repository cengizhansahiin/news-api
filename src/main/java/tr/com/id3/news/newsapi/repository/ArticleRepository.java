package tr.com.id3.news.newsapi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.id3.news.newsapi.model.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {

}
