/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author qphan
 */
public interface ConfigurationProvider {
    Properties getConfiguration() throws Exception;
}
