package servlets;


import dice.Game;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import score.HighScore;

@WebServlet(name="Player",urlPatterns={"/Player"})
public class Player extends HttpServlet {

    @Override
public void doGet (HttpServletRequest request, 
		   HttpServletResponse response) throws ServletException, IOException {        
	String	title = "Player Info";
	HttpSession session=request.getSession(true);
	Game j=null;
	session.setAttribute("game",j=new Game(request.getParameter("pname")));
        j.setHs((HighScore)request.getServletContext().getAttribute("score"));
	PrintWriter out=response.getWriter();
	response.setContentType("text/html");
 	out.println("<HTML><HEAD><TITLE>");
 	out.println(title);
 	out.println("</TITLE></HEAD><BODY>");
	out.println(j.toString());
	out.println("<FORM action=\"Play\" method=\"get\">");
        out.println("<INPUT type=\"submit\" value=\"OK\">");
      	out.println("<P>");
	out.println("</FORM>");
	out.println("</BODY></HTML>");
	out.close();
	}
}


