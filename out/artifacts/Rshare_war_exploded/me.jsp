<%--
  Created by IntelliJ IDEA.
  User: df
  Date: 2021/7/17
  Time: 18:44
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
    <link rel="stylesheet" href="./me.css">
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
                <div class="link">
                    <i class="fa fa-user-circle" aria-hidden="true"></i>
                    <span>个人中心</span>
                </div>
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
        <form action="./UpdateServlet" METHOD="post" class="main">
            <div class="input-box">
                <h3>姓名</h3>
                <input type="text" value="<%=person.getUname()%>" name="uname" id="uname1">
                <i class="fa fa-times icon1" aria-hidden="true"></i>
                <i class="fa fa-check icon2" aria-hidden="true"></i>
            </div>
            <div class="input-box">
                <h3>密码</h3>
                <input type="text" value="<%=person.getUpwd()%>" name="upwd" id="upwd1">
                <i class="fa fa-times icon1" aria-hidden="true"></i>
                <i class="fa fa-check icon2" aria-hidden="true"></i>
            </div>
            <div class="input-box">
                <h3>邮箱</h3>
                <input type="email" value="<%=person.getEmail()%>" name="email" id="email1">
                <i class="fa fa-times icon1" aria-hidden="true"></i>
                <i class="fa fa-check icon2" aria-hidden="true"></i>
            </div>
            <div class="input-box">
                <h3>手机</h3>
                <input type="text" value="<%=person.getPhone()%>" name="phone" id="phone1">
                <i class="fa fa-times icon1" aria-hidden="true"></i>
                <i class="fa fa-check icon2" aria-hidden="true"></i>
            </div>
            <button>修改</button>
        </form>
    </section>
</main>
<div class="circle1"></div>
<div class="circle2"></div>
<script src="/user/js/jquery-3.1.1.min.js"></script>
<script>

    var inputBox = document.getElementsByClassName("input-box");
    var icon1 = document.getElementsByClassName("icon1");
    var icon2 = document.getElementsByClassName("icon2");

    var name = document.getElementById("uname1").getAttribute("value");
    var upwd = document.getElementById("upwd1").getAttribute("value");
    var email = document.getElementById("email1").getAttribute("value");
    var phone = document.getElementById("phone1").getAttribute("value");

    $("#uname1").blur(function () {
        var data = $("#uname1").val();//获取了该input标签中的数据
        if (data == null || data == "") {
            $("#uname1").attr('placeholder', '用户名不能为空');
            icon1[0].setAttribute("style", "display: inline;");
            inputBox[0].setAttribute("style", "animation: shake 0.2s linear;");
            setTimeout(function () {
                icon1[0].setAttribute("style", "display: none;");
                inputBox[0].setAttribute("style", "animation: none;");
                $("#uname1").val(name);
            }, 900)
        } else {
            $.ajax({
                //请求方式
                type: "POST",
                //请求地址
                url: "/CheckUnameServlet",
                //请求参数
                data: "uname=" + data,
                //请求成功
                success: function (msg) {
                    //msg:服务器响应内容
                    if ("no" == msg) {
                        icon2[0].setAttribute("style", "display: inline;");
                    } else if ("yes" == msg) {
                        $("#uname1").val("");
                        $("#uname1").attr('placeholder', '用户名存在');
                        icon1[0].setAttribute("style", "display: inline;");
                        inputBox[0].setAttribute("style", "animation: shake 0.2s linear;");
                        setTimeout(function () {
                            icon1[0].setAttribute("style", "display: none;");
                            inputBox[0].setAttribute("style", "animation: none;");
                            $("#uname1").val(name);
                        }, 900)
                    }
                },
                //请求失败
                error: function () {
                }
            });
        }
    });

    $("#upwd1").blur(function () {
        var data = $("#upwd1").val();//获取了该input标签中的数据
        if (data == null || data == "") {
            $("#upwd1").attr('placeholder', '密码不能为空');
            icon1[1].setAttribute("style", "display: inline;");
            inputBox[1].setAttribute("style", "animation: shake 0.2s linear;");
            setTimeout(function () {
                icon1[1].setAttribute("style", "display: none;");
                inputBox[1].setAttribute("style", "animation: none;");
                $("#upwd1").val(upwd);
            }, 900)
        } else {
            icon2[1].setAttribute("style", "display: inline;");
        }
    });

    $("#email1").blur(function () {
        var data = $("#email1").val();//获取了该input标签中的数据
        if (data == null || data == "") {
            $("#email1").attr('placeholder', '邮箱不能为空');
            icon1[2].setAttribute("style", "display: inline;");
            inputBox[2].setAttribute("style", "animation: shake 0.2s linear;");
            setTimeout(function () {
                icon1[2].setAttribute("style", "display: none;");
                inputBox[2].setAttribute("style", "animation: none;");
                $("#email1").val(email)
            }, 900)
        } else {
            icon2[2].setAttribute("style", "display: inline;");
        }
    });

    $("#phone1").blur(function () {
        var data = $("#phone1").val();//获取了该input标签中的数据
        if (data == null || data == "") {
            $("#phone1").attr('placeholder', '手机号不能为空');
            icon1[3].setAttribute("style", "display: inline;");
            inputBox[3].setAttribute("style", "animation: shake 0.2s linear;");
            setTimeout(function () {
                icon1[3].setAttribute("style", "display: none;");
                inputBox[3].setAttribute("style", "animation: none;");
                $("#phone1").val(phone);
            }, 900)
        } else {
            $.ajax({
                //请求方式
                type: "POST",
                //请求地址
                url: "/CheckPhoneServlet",
                //请求参数
                data: "phone=" + data,
                //请求成功
                success: function (msg) {
                    //msg:服务器响应内容
                    if ("no" == msg) {
                        icon2[3].setAttribute("style", "display: inline;");
                    } else if ("yes" == msg) {
                        $("#phone1").val("");
                        $("#phone1").attr('placeholder', '手机号存在');
                        icon1[3].setAttribute("style", "display: inline;");
                        inputBox[3].setAttribute("style", "animation: shake 0.2s linear;");
                        setTimeout(function () {
                            icon1[3].setAttribute("style", "display: none;");
                            inputBox[3].setAttribute("style", "animation: none;");
                            $("#phone1").val(phone);
                        }, 900)
                    }
                },
                //请求失败
                error: function () {
                }
            });
        }
    });

</script>
</body>

</html>
