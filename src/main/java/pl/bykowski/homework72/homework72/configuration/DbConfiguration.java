package pl.bykowski.homework72.homework72.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


@Configuration
public class DbConfiguration {

    private DataSource dataSource;

    @Autowired
    public DbConfiguration(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTplate() {
        return new JdbcTemplate(dataSource);
    }

  // @EventListener(ApplicationReadyEvent.class)
  // public void init() {
  //     String sql = "CREATE TABLE news (news_id int NOT NULL AUTO_INCREMENT , title varchar(255), article varchar(5000), author varchar(255), PRIMARY KEY(news_id))";
  //     getJdbcTplate().update(sql);
  // }
}
