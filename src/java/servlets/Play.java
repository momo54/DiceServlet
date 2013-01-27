package servlets;

import dice.Game;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "Play", urlPatterns = {"/Play"})
public class Play extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<HTML><HEAD><TITLE>");
        out.println("Playing");
        out.println("</TITLE></HEAD><BODY>");

        Game g = ((Game) request.getSession().getAttribute("game"));
        g.play();
        if (!(g.isfinished())) {
            out.println(g.toString());
            out.println("<FORM action=\"Play\" method=\"get\">");
            out.println("<INPUT type=\"submit\" value=\"OK\">");
            out.println("</FORM>");
        } else {
            request.getSession().invalidate();
            out.println("Game Over\n");
            out.println("<FORM action=\"index.jsp\" method=\"get\">");
            out.println("<INPUT type=\"submit\" value=\"OK\">");
            out.println("</FORM>");

        }

        out.println("</BODY></HTML>");
        out.close();
    }
}
