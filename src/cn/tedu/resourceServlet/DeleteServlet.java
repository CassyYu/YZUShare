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

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //设置字符集
        request.setCharacterEncoding("utf-8");
        String fileName = request.getParameter("address");
//        String id=request.getParameter("id");
//        int id1 = new Integer(id);
        ResDao resDao = new ResDao();
        resDao.deleteByAddr(fileName);
        //上传的文件都是保存在/WEB-INF/upload目录下的子目录当中
        String fileSaveRootPath = this.getServletContext().getRealPath("/WEB-INF/upload");
        System.out.println("fileSaveRootPath:" + fileSaveRootPath);
        //通过文件名找出文件的所在目录
        String path = findFileSavePathByFileName(fileName, fileSaveRootPath);
        System.out.println("path:" + path);
        //得到要下载的文件
        File file = new File(path + "\\" + fileName);
        System.out.println("file:" + file);
        file.delete();
        //转发
        request.getRequestDispatcher("/ContributeServlet").forward(request, response);
    }


    //查找文件
    public String findFileSavePathByFileName(String filename, String saveRootPath) {
        int hashcode = filename.hashCode();
        int dir1 = hashcode & 0xf;  //0--15
        int dir2 = (hashcode & 0xf0) >> 4;  //0-15
        String dir = saveRootPath + "\\" + dir1 + "\\" + dir2;  //upload\2\3  upload\3\5
        File file = new File(dir);
        if (!file.exists()) {
            //创建目录
            file.mkdirs();
        }
        return dir;
    }

}
