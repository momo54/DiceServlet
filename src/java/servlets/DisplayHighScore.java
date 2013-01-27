package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import score.HighScore;

@WebServlet(name = "DisplayHighScore", urlPatterns = {"/DisplayHighScore"})
public class DisplayHighScore extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<HTML><HEAD><TITLE>");
        out.println("Playing");
        out.println("</TITLE></HEAD><BODY>");
        out.println("<H1> HIGHSCORE </H1>");

        HighScore hs = (HighScore) request.getServletContext().getAttribute("score");
        out.println(hs.toString());

        out.println("<FORM action=\"index.jsp\" method=\"get\">");
        out.println("<INPUT type=\"submit\" value=\"OK\">");
        out.println("</FORM>");


        out.println("</BODY></HTML>");
        out.close();
    }
}
