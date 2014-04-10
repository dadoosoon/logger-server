package im.dadoo.logger.server.configuration;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.WriteConcern;
import java.net.UnknownHostException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author codekitten
 */
@Configuration
@EnableWebMvc
@ComponentScan("im.dadoo.logger.server")
public class Context {
  
  @Bean
  public MongoClient mongoClient() throws UnknownHostException {
    MongoClientOptions options = 
      MongoClientOptions.builder().autoConnectRetry(true)
              .socketKeepAlive(true).writeConcern(WriteConcern.FSYNCED).build();               
    return new MongoClient("mongo.dadoo.im:27017", options);
  }
  
  @Bean
  public MongoTemplate mongoTemplate() throws UnknownHostException {
    return new MongoTemplate(this.mongoClient(), "dadoo");
  }
}
