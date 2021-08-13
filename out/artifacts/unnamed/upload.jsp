<%--
  Created by IntelliJ IDEA.
  User: df
  Date: 2021/7/17
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="cn.tedu.entity.Person" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="./upload.css">
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
                <div class="link">
                    <i class="fa fa-upload" aria-hidden="true"></i>
                    <span>资源上传</span>
                </div>
                <a href="./ContributeServlet">
                    <div class="link">
                        <i class="fa fa-star" aria-hidden="true"></i>
                        <span>个人贡献</span>
                    </div>
                </a>
            </div>
            <div class="reward">
                <span>欢迎打赏开发者~</span>
                <img src="./img/code.jpg" alt="QRCode" />
            </div>
        </div>
        <div class="head">
            <span class="logo">YZUShare</span>
        </div>
        <div class="main">
            <form action="./UploadServlet" method="post" enctype="multipart/form-data">
                <h2>文件上传</h2>
                <input type="file" value="选择文件" name="rname" id="rname">
                <h2>文件描述</h2>
                <textarea name="des"></textarea>
                <button>提交</button>
            </form>
        </div>
    </section>
</main>
<div class="circle1"></div>
<div class="circle2"></div>
</body>

</html>
