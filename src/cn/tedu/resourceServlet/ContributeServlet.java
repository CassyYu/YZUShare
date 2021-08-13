package cn.tedu.resourceServlet;


import cn.tedu.dao.ResDao;
import cn.tedu.entity.Person;
import cn.tedu.entity.Resource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/ContributeServlet")
public class ContributeServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //设置字符集
        request.setCharacterEncoding("utf-8");
        //从session中获取user对象
        Person person = (Person) request.getSession().getAttribute("person");
        ResDao resDao = new ResDao();
        ArrayList<Resource> list = resDao.selectByUname(person);
        //转发
        request.setAttribute("res", list);
        request.getRequestDispatcher("contribute.jsp").forward(request, response);
    }
}
