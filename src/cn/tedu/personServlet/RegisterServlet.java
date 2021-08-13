package cn.tedu.personServlet;

import cn.tedu.dao.PersonDao;
import cn.tedu.entity.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //设置字符集
        request.setCharacterEncoding("utf-8");
        String uname = request.getParameter("uname");
        String upwd = request.getParameter("upwd");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        Person person = new Person();
        person.setUname(uname);
        person.setUpwd(upwd);
        person.setEmail(email);
        person.setState(0);
        person.setRole(0);
        person.setPhone(phone);
        PersonDao personDao = new PersonDao();
        personDao.insert(person);
        //注册成功,跳转至登录页面
        request.getRequestDispatcher("login.html").forward(request, response);
    }
}
