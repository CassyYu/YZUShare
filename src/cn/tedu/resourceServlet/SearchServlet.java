package cn.tedu.resourceServlet;

import cn.tedu.dao.ResDao;
import cn.tedu.entity.Resource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //设置字符集
        request.setCharacterEncoding("utf-8");
        //获取参数
        String search = request.getParameter("search");
        if (search == null) return;
        ResDao resDao = new ResDao();
        ArrayList<Resource> list = resDao.selectBySearch(search);
        request.setAttribute("res", list);
        request.getRequestDispatcher("home.jsp").forward(request, response);

    }
}
