/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package im.dadoo.logger.server.controller;

import im.dadoo.log.Log;
import im.dadoo.logger.server.service.LoggerService;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author codekitten
 */
@Controller
public class LoggerController {
  
  protected static final Logger logger = LoggerFactory.getLogger(LoggerController.class);
  
  @Resource
  private LoggerService loggerService;
  
  @RequestMapping(value = "/logger", method = RequestMethod.POST)
  @ResponseBody
  public Boolean save(@RequestBody Log log) {
    Boolean b = this.loggerService.save(log);
    if (b) {
      logger.info(String.format("保存成功,log内容为:%s", log.toPropertyString()));
    } else {
      logger.error(String.format("保存失败,log内容为:%s", log.toString()));
    }
    return b;
  }
  
  @RequestMapping(value = "/test", method = RequestMethod.GET)
  @ResponseBody
  public String test() {
    return "test";
  }
}
