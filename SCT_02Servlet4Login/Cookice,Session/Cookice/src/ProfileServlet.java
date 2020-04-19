import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=GBK");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("link.html").include(request, response);
        Cookie ck[] = request.getCookies();
        if (ck != null) {
            String name = ck[0].getValue();
            if (!name.equals("") || name != null) {
                out.print("<b>��ӭ������������</b>");
                out.print("<br>���, " + name);
            }
        } else {
            out.print("���ȵ�¼~");
            request.getRequestDispatcher("login.html").include(request, response);
        }
        out.close();
    }
}