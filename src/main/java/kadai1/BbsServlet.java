package kadai1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/BbsServlet")
public class BbsServlet extends HttpServlet {

    private List<String> messages = new ArrayList<>();

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        // 取得
        String name = request.getParameter("name");
        String message = request.getParameter("message");

        // 名前が空なら「匿名」
        if (name == null || name.isEmpty()) {
            name = "匿名";
        }

        // メッセージがある場合だけ保存
        if (message != null && !message.isEmpty()) {
            messages.add(name + "：" + message);
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>掲示板</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h3>メッセージ：</h3>");

        // フォーム
        out.println("<form action='/jmaster/BbsServlet' method='post'>");
        out.println("名前：<br>");
        out.println("<input type='text' name='name' style='width:200px;'><br><br>");
        out.println("メッセージ：<br>");
        out.println("<textarea name='message' style='width:400px; height:100px;'></textarea><br>");
        out.println("<button type='submit'>書き込み</button>");
        out.println("</form>");

        out.println("<hr>");

        // 表示
        for (String m : messages) {
            out.println("<div>" + m + "</div>");
            out.println("<hr>");
        }

        out.println("</body>");
        out.println("</html>");

        out.close();
    }
}