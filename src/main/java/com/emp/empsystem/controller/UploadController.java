package com.emp.empsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author Liu
 * @create 2019/4/24 20:29
 */
@Controller
public class UploadController {
    /**
     * 实现文件上传
     * */
    @RequestMapping(value = "/ramanage", method = RequestMethod.POST)
    @ResponseBody
    public static void uploadFile(MultipartFile file, HttpServletRequest request, String path)
            throws IllegalStateException, IOException {
        // String url =
        // request.getSession().getServletContext().getRealPath("/"); //服务器地址
        if (!file.isEmpty()) {
            // 文件保存路径
            String filePath = path + file.getOriginalFilename();
            // 转存文件
            file.transferTo(new File(filePath));
        }
    }
}
