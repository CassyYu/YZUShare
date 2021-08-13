package cn.tedu.personServlet;

import cn.tedu.dao.PersonDao;
import cn.tedu.entity.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet("/CheckPhoneServlet")
public class CheckPhoneServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //设置字符集
        request.setCharacterEncoding("utf-8");
        //获取参数
        String phone = request.getParameter("phone");
        if (phone == null) return;
        Person person = new Person();
        person.setPhone(phone);
        PersonDao personDao = new PersonDao();
        Person person1 = personDao.selectByPhone(person);
        boolean isExisting = false;
        if (null != person1) {
            //isExisting 表示输入的账号存在
            isExisting = true;//开关
        }
        Writer out = null;
        out = response.getWriter();
        //输入的账号存在响应浏览器 yes
        if (isExisting) {
            out.write("yes");
            System.out.println(phone + "存在");
        } else {
            //输入的账号不存在响应浏览器 no
            out.write("no");
            System.out.println(phone + "不存在");
        }
        out.close();

    }
}
