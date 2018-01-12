package com.tosit.emps.action;

import com.tosit.emps.entity.User;
import com.tosit.emps.service.UserService;
import com.tosit.emps.service.UserServiceImpl;
import com.tosit.framework.mvc.annotation.RequestPath;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RequestPath("/user")
public class UserAction {


    //控制层注入 服务层
    private UserService userService;

    public UserAction() {
        this.userService = new UserServiceImpl();
    }

    @RequestPath("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rs = "/WEB-INF/emp/emp_login.jsp";
        if (request.getSession().getAttribute("lastTimeLogin") != null) {
            String code = request.getParameter("code");
            String codeInSession = (String) request.getSession().getAttribute("ver_code");

            if (!codeInSession.equalsIgnoreCase(code)) {
                request.setAttribute("errMsg", "验证码错误");
                return rs;
            }
        }

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        User u = userService.findUserByName(name);
        if (u == null) {
            request.setAttribute("errMsg", "用户不存在");
            return rs;
        }
        if (u.getPassword().equals(password)) {
            //登录成功后把 当前用户添加到Session 中
            request.getSession().setAttribute("current_user", u);
            request.getSession().setAttribute("loginUserMsg", u.getName() + " 您好");
            rs = "/emp/listemp.do";
        } else {
            request.setAttribute("errMsg", "密码错误");
            request.getSession().setAttribute("lastTimeLogin", System.currentTimeMillis());

        }

        return rs;
    }

    @RequestPath("/exit")
    public String userexit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("current_user", null);
        request.getSession().invalidate();//失效
        return "/index.jsp";
    }

    @RequestPath("/toregist")
    public String toregist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return "/WEB-INF/emp/emp_regist.jsp";
    }

    @RequestPath("/regist")
    public String regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] imageTypes = new String[]{"image/jpeg", "image/png", "image/bmp"};
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);//验证提交的格式
        User u = null;
        if (isMultipart) {
            // Create a factory for disk-based file items
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            try {
                List<FileItem> items = upload.parseRequest(request);
                u = new User();
                for (FileItem item :
                        items) {
                    if (item.isFormField()) {
                        String name = item.getFieldName();//
                        switch (name){
                            case "name":
                                u.setName(item.getString("UTF-8"));
                                break;
                            case "password":
                                u.setPassword(item.getString("UTF-8"));
                        }

                    } else {
                        String fieldName = item.getFieldName();
                        String fileName = item.getName();
                        String contentType = item.getContentType();

                        boolean typeatch =  Arrays.asList(imageTypes).contains(contentType);//判断数组中是否包含某个值

                        long sizeInBytes = item.getSize();
                        if( !(typeatch && sizeInBytes<1000000) ){
                            request.setAttribute("errMsg","上传失败");
                            return "/WEB-INF/emp/emp_regist.jsp";
                        }
                        String uploadDir="/upload";

                        String filePathSave = request.getSession().getServletContext().getRealPath(uploadDir);
                        File p = new File(filePathSave);
                        if(!p.exists()){
                            p.mkdir();
                        }
                        String fileName4save = new SimpleDateFormat("yyyyMMddhhmm").format(new Date()) + (int) (Math.random() * 10000) + (fileName.substring(fileName.lastIndexOf(".")));
                        u.setImage(uploadDir+"/"+fileName4save);
                        System.out.println(fileName4save);
                        File fileSave = new File(p, fileName4save);

                     /*   FileOutputStream fos = new FileOutputStream(fileSave);
                        InputStream in = item.getInputStream();
                        byte[] bs = new byte[512];
                        while (true){
                            int count  = in.read(bs);
                            if(count==-1){
                                break;
                            }
                            fos.write(bs,0,count);
                            fos.flush();
                        }
                        fos.close();
                        in.close();*/
                        item.write(fileSave);
                        //item.w
                    }
                }
                System.out.println("文件已经保存");
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if(u!=null){
            userService.addUser(u);
            request.setAttribute("user",u);
        }


        return "/WEB-INF/emp/emp_regist_success.jsp";
    }
}
