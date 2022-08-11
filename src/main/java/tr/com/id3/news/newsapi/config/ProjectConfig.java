package tr.com.id3.news.newsapi.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("tr.com.id3.news.newsapi")
@EnableAutoConfiguration
@PropertySource("application.properties")
public class ProjectConfig {
}
