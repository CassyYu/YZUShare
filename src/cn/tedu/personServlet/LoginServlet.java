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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //设置字符集
        request.setCharacterEncoding("utf-8");
        System.out.println("Login");
        //获取参数
        String uname = request.getParameter("uname");
        String upwd = request.getParameter("upwd");
        System.out.println(uname);
        System.out.println(upwd);
        if (uname == null) return;
        Person person = new Person();
        person.setUname(uname);
        person.setUpwd(upwd);
        person.setRole(0);//设置角色为消费者

        PersonDao personDao = new PersonDao();//创建UserDao
        Person person1 = personDao.login(person);
//        request.getSession().setAttribute("person",person1);
//        request.getRequestDispatcher("/AllResourceServlet").forward(request,response);
        //定义一个开关变量，赋值为false,表示输入的账号不存在
//        boolean isExisting = false;
//        if (null != person1) {
//            //isExisting 表示输入的账号存在
//            isExisting = true;//开关
//        }
//        Writer out = null;
//        out = response.getWriter();
//        //输入的账号存在响应浏览器 yes
//        if (isExisting) {
//            request.getSession().setAttribute("person", person1);
//            out.write("yes");
//            System.out.println("登陆成功");
//        } else {
//            //输入的账号不存在响应浏览器 no
//            System.out.println("登录失败");
//        }
//        out.close();


        String result="login.html";
        if(person1!=null){
//        将user1绑定在一个服务器端共享的对象上session
//        将user1绑定在session的attribute属性上，并标记为user
            request.getSession().setAttribute("person", person1);
            result="/AllResourceServlet";
        }
        request.getRequestDispatcher(result).forward(request,response);
    }
}
