/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package im.dadoo.logger.server.service.impl;

import im.dadoo.log.Log;
import im.dadoo.logger.server.service.LoggerService;
import javax.annotation.Resource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author codekitten
 */
@Component("loggerService")
public class MongoLoggerService implements LoggerService {
  
  @Resource
  private MongoTemplate mongoTemplate;
  
  @Override
  public Boolean save(Log log) {
    if (log != null) {
      log.setSaveDatetime(System.currentTimeMillis());
      this.mongoTemplate.save(log, "log");
      return true;
    } else {
      return false;
    }
  }
  
}
