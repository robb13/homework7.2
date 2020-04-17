package pl.bykowski.homework72.homework72.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.bykowski.homework72.homework72.model.News;


@Service
public class NewsService {

    private String url = "http://newsapi.org/v2/everything?domains=wsj.com,nytimes.com&apiKey=211caa2dbeff4cdab54936ed284a3d31";

    public News getNewsRest() {
        RestTemplate restTemplate = new RestTemplate();
        News newsObject = restTemplate.getForObject(url, News.class);
        return newsObject;
    }

}
