<%--
  Created by IntelliJ IDEA.
  User: df
  Date: 2021/7/17
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.ArrayList" %>
<%@ page import="cn.tedu.entity.Person" %>
<%@ page import="cn.tedu.entity.Resource" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="./contribute.css">
    <title>YZUShare</title>
</head>

<body>
<main>
    <section class="glass">
        <div class="dashboard">
            <div class="user">
                <img src="./img/avtar.jpg" alt=""/>
                <%
                    Person person = (Person) request.getSession().getAttribute("person");
                %>
                <span><%=person.getUname()%></span>
                <span><%=person.getEmail()%></span>
            </div>
            <div class="links">
                <a href="./me.jsp">
                    <div class="link">
                        <i class="fa fa-user-circle" aria-hidden="true"></i>
                        <span>个人中心</span>
                    </div>
                </a>
                <a href="./AllResourceServlet">
                    <div class="link">
                        <i class="fa fa-thumbs-up" aria-hidden="true"></i>
                        <span>热门分享</span>
                    </div>
                </a>
                <a href="./upload.jsp">
                    <div class="link">
                        <i class="fa fa-upload" aria-hidden="true"></i>
                        <span>资源上传</span>
                    </div>
                </a>
                <div class="link">
                    <i class="fa fa-star" aria-hidden="true"></i>
                    <span>个人贡献</span>
                </div>
            </div>
            <div class="reward">
                <span>欢迎打赏开发者~</span>
                <img src="./img/code.jpg" alt="QRCode" />
            </div>
        </div>
        <form action="/ContributeSearchServlet" method="post">
            <div class="head">
                <input type="text" placeholder="搜索" id="search" name="search"/>
                <button><i class="fa fa-search" aria-hidden="true"></i></button>
                <span class="logo">YZUShare</span>
            </div>
        </form>
        <div class="source">
            <div class="cards">
                <%
                    ArrayList<Resource> resources = (ArrayList<Resource>) request.getAttribute("res");
                    System.out.println(resources.size());
                    for (int i = 0; i < resources.size(); i++) {
                        Resource res = resources.get(i);
                %>
                <div class="card">
                    <div class="order"><%=i + 1%>
                    </div>
                    <span>文件名：<span><%=res.getRname()%></span></span>
                    <span>文件描述：<span><%=res.getDes()%></span></span>
                    <span>
                        <span>上传者：<span><%=res.getUname()%></span></span>
                        <span>上传时间：<%=res.getDate()%></span>
                    </span>
                    <a href="./DeleteServlet?address=<%=res.getAddress()%>" onclick="return confirm('确认删除吗？')">
                        <button>删除</button>
                    </a>
                </div>
                <%
                    }
                %>
            </div>
        </div>
    </section>
</main>
<div class="circle1"></div>
<div class="circle2"></div>
</body>

</html>