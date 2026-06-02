package lecture1.la.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/PlusServlet")
public class PlusServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // リクエストパラメータ取得
        String num1 = request.getParameter("number1");
        String num2 = request.getParameter("number2");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Plus</title></head><body>");

        try {
            // 文字列→整数変換
            int i1 = Integer.parseInt(num1);
            int i2 = Integer.parseInt(num2);

            // 足し算
            int answer = i1 + i2;

            // 結果表示
            out.println(i1 + " + " + i2 + " = " + answer);

        } catch (NumberFormatException e) {

            // エラー表示
            out.println("<h3>エラー</h3>");
            out.println("数字を入力してください。");
        }

        out.println("</body></html>");
        out.close();
    }
}