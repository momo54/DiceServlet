/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import score.HighScore;

/**
 * Web application lifecycle listener.
 * @author molli
 */
@WebListener()
public class DiceGameListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("score", new HighScore());
    }

    public void contextDestroyed(ServletContextEvent sce) {
    }
}
