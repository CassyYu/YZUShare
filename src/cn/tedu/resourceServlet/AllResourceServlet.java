package cn.tedu.resourceServlet;

import cn.tedu.dao.ResDao;
import cn.tedu.entity.Resource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


@WebServlet("/AllResourceServlet")
public class AllResourceServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //设置字符集
        request.setCharacterEncoding("utf-8");
        //查询所有资料
        ResDao resDao = new ResDao();
        ArrayList<Resource> list = resDao.selectAll();
        request.setAttribute("res", list);
        System.out.println(list.size());
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
//        //获取上传文件的目录
//        String uploadFilePath = this.getServletContext().getRealPath("/WEB-INF/upload");
//        //存储要下载的文件名
//        Map<String, String> fileNameMap = new HashMap<String, String>();
//        //递归遍历filepath目录下的所有文件和目录，将文件的文件名存储到map集合中
//        ArrayList<Resource> list =new ArrayList<Resource>();
//        ResDao resDao = new ResDao();
//        listfile(new File(uploadFilePath), fileNameMap);//File既可以代表一个文件也可以代表一个目录
//        Iterator iter=fileNameMap.entrySet().iterator();
//        while(iter.hasNext()){
//            Map.Entry entry=(Map.Entry) iter.next();
//            String val=(String)entry.getValue();
//            System.out.println(val);
//            Resource res1=resDao.selectByRname(val);
//            try{
//                list.add(res1);
//            }catch (Exception e){ }
//        }
//        request.setAttribute("res",list);
//        request.getRequestDispatcher("home.jsp").forward(request,response);
//
//    }
//
//    public void listfile(File file,Map<String,String> map){
//        //如果file代表的不是一个文件，而是一个目录
//        if(!file.isFile()){
//            //列出该目录下的所有文件和目录
//            File files[] = file.listFiles();
//            //遍历files[]数组
//            for(File f : files){
//                //递归
//                listfile(f,map);
//            }
//        }else{
//            /**
//             * 处理文件名，上传后的文件是以uuid_文件名的形式去重新命名的，去除文件名的uuid_部分
//             file.getName().indexOf("_")检索字符串中第一次出现"_"字符的位置，如果文件名类似于：9349249849-88343-8344_阿_凡_达.avi
//             那么file.getName().substring(file.getName().indexOf("_")+1)处理之后就可以得到阿_凡_达.avi部分
//             */
//            String realName = file.getName().substring(file.getName().indexOf("_")+1);
//            //file.getName()得到的是文件的原始名称，这个名称是唯一的，因此可以作为key，realName是处理过后的名称，有可能会重复
//            map.put(file.getName(), realName);
//        }
//    }
}
