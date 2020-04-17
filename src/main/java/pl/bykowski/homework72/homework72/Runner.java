package pl.bykowski.homework72.homework72;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.bykowski.homework72.homework72.dao.NewsDao;
import pl.bykowski.homework72.homework72.model.Article;


@Component
public class Runner {

    private NewsDao newsDao;

    @Autowired
    public Runner(NewsDao newsDao) {
        this.newsDao = newsDao;
        newsDao.saveArticleFromApi();
       // newsDao.updateArticle( new Article(1L,"ss","ss", "aa"));
       // newsDao.findAll().forEach(System.out::println);
    }
}
