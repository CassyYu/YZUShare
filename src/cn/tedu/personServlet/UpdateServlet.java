package cn.tedu.personServlet;

import cn.tedu.dao.PersonDao;
import cn.tedu.entity.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //设置字符集
        response.setCharacterEncoding("utf-8");
        //获取原先的phone
        Person person1 = (Person) request.getSession().getAttribute("person");
        String phone1 = person1.getPhone();
        //获取参数
        String uname = request.getParameter("uname");
        String upwd = request.getParameter("upwd");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        Person person = new Person();
        person.setUname(uname);
        person.setUpwd(upwd);
        person.setEmail(email);
        person.setPhone(phone);
        person.setState(0);
        person.setRole(0);
        PersonDao personDao = new PersonDao();
        personDao.update(person, phone1);
        request.getSession().setAttribute("person", person);
        request.getRequestDispatcher("/AllResourceServlet").forward(request, response);
    }
}
