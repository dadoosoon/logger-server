/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package im.dadoo.logger.server.service;

import im.dadoo.log.Log;

/**
 *
 * @author codekitten
 */
public interface LoggerService {
  
  public Boolean save(Log log);
}
