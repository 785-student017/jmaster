package kadai1;


import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/BbsServlet")
public class BbsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>掲示板</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("メッセージ：<br>");

        out.println("<form action='/jmaster/BbsServlet' method='post'>");
        out.println("<textarea name='message' style='width:300px; height:100px;'></textarea><br>");
        out.println("<button type='submit'>書き込み</button>");
        out.println("</form>");

        out.println("<hr>");

        out.println("</body>");
        out.println("</html>");

        out.close();
    }
}