import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
    /*使用session处理用户登录*/
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        List<User> list = Db.getAll();
        for(User u: list){
            if(u.getUsername().equals(username) && u.getPassword().equals(password)){
                request.getSession().setAttribute("user", u);//登录成功，将用户数据放入到Session中
                response.sendRedirect("/Web/index.jsp");
                return;//进行重定向，并且下面的代码不再执行
            }
        }

        out.write("用户名或密码错误，请重新登录！");
        request.getRequestDispatcher("index.jsp").include(request, response);
        out.close();
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
}
class Db{
    public static List<User> list = new ArrayList<User>();
    static{
        list.add(new User("aaa","123"));
        list.add(new User("bbb","123"));
        list.add(new User("ccc","123"));
    }

    public static List<User> getAll(){
        return list;
    }
}
