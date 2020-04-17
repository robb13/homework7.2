package pl.bykowski.homework72.homework72.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import pl.bykowski.homework72.homework72.service.NewsService;
import pl.bykowski.homework72.homework72.model.Article;
import pl.bykowski.homework72.homework72.newsInterface.NewsInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class NewsDao implements NewsInterface {


    private List<Article> articleList;
    private JdbcTemplate jdbcTemplate;
    private NewsService newsService;


    @Autowired
    public NewsDao(JdbcTemplate jdbcTemplate, NewsService newsService) {
        this.jdbcTemplate = jdbcTemplate;
        this.newsService = newsService;
        this.articleList = new ArrayList<>();
    }

    @Override
    public List<Article> findAll() {
        articleList.clear();
        String sql = "SELECT * FROM news";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        maps.stream().forEach(element -> articleList.add(new Article(
                Long.parseLong(String.valueOf(element.get("news_id"))),
                String.valueOf(element.get("title")),
                String.valueOf(element.get("article")),
                String.valueOf(element.get("author"))
        )));

        return articleList;

    }

    @Override
    public void saveArticleFromApi() {
        jdbcTemplate.execute("TRUNCATE TABLE news");
        List<Article> getNews = newsService.getNewsRest().getArticles();
        for (Article getNew : getNews) {
            String sql = "INSERT INTO news VALUES (?,?,?,?)";
            jdbcTemplate.update(sql,
                    getNew.getArticleId(),
                    getNew.getTitle(),
                    getNew.getDescription(),
                    getNew.getAuthor());

        }

    }

    @Override
    public void updateArticle(Article newArticle) {
        String sql = "UPDATE news SET news.title=?, news.article =?, news.author =? WHERE news.news_id = ?";
        jdbcTemplate.update(sql,
                newArticle.getTitle(),
                newArticle.getDescription(),
                newArticle.getAuthor(),
                newArticle.getArticleId());

    }


}



