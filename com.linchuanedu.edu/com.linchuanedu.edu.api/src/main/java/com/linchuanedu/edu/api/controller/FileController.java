package com.linchuanedu.edu.api.controller;

import com.linchuanedu.edu.common.model.DTO.CreateCourseDTO;
import com.linchuanedu.edu.common.model.VO.ServerResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * Created by pansp on 2017-10-9.
 */
@RestController
@RequestMapping(value = "/v1/edu/app/file")
public class FileController extends AbstractController {
    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    //文件上传相关代码
    @RequestMapping(value = "/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file, @RequestParam("token") String token) {
        if (file.isEmpty()) {
            return "文件为空";
        }

        logger.info("另外一个参数：" + token);
        // 获取文件名
        String fileName = file.getOriginalFilename();
        logger.info("上传的文件名为：" + fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        logger.info("上传的后缀名为：" + suffixName);
        // 文件上传后的路径
        String filePath = "E://test//";
        // 解决中文问题，liunx下中文路径，图片显示问题
        // fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath + fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            return "上传成功";
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }

    //文件下载相关代码
    @RequestMapping("/download")
    public String downloadFile(org.apache.catalina.servlet4preview.http.HttpServletRequest request, HttpServletResponse response) {
        String fileName = "FileUploadTests.java";
        if (fileName != null) {
            //当前是从该工程的WEB-INF//File//下获取文件(该目录可以在下面一行代码配置)然后下载到C:\\users\\downloads即本机的默认下载的目录
            String realPath = request.getServletContext().getRealPath(
                    "//WEB-INF//");
//            File file = new File(realPath, fileName);
            File file = new File("");
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition",
                        "attachment;fileName=" + fileName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("success");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }

    //多文件上传
    @RequestMapping(value = "/batch/upload", method = RequestMethod.POST)
    @ResponseBody
    public String handleFileUpload(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request)
                .getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(
                            new File(file.getOriginalFilename())));
                    stream.write(bytes);
                    stream.close();

                } catch (Exception e) {
                    stream = null;
                    return "You failed to upload " + i + " => "
                            + e.getMessage();
                }
            } else {
                return "You failed to upload " + i
                        + " because the file was empty.";
            }
        }
        return "upload successful";
    }


    @RequestMapping("/download2/{appId}")
    public void downProcess(HttpServletRequest request, HttpServletResponse response, @RequestParam(required = true) String filekey, @RequestParam(required = false)String fileName, @PathVariable("appId") String appId) {
        try {
//            String path = sysConfig.getDownpath() + filekey;
            logger.info("appId is ====> {}", appId);
            String path = "E:\\test\\" + filekey;
            File file = new File(path);
            String contentType = "application/octet-stream";
            //下载文件
            InputStream fis = new BufferedInputStream(new FileInputStream(path));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            //清空response
            response.reset();
//            if(fileName==null){
//                fileName = "ApprovalInfo.xls";
//            }
            //设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("utf-8"), "ISO-8859-1"));
            response.addHeader("Content-Length", "" + file.length());
            OutputStream fos = new BufferedOutputStream(response.getOutputStream());
            response.setContentType(contentType);
            fos.write(buffer);
            fos.flush();
            fos.close();
            //删除文件
//            file.delete();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ServerResponse createCourse(HttpServletRequest request, HttpServletResponse response) {
        request.getSession();
        Cookie cookie = new Cookie("test","wahaha");
        response.addCookie(cookie);
        System.out.println("come in!");

        return new ServerResponse("2000", "good");
    }

}
