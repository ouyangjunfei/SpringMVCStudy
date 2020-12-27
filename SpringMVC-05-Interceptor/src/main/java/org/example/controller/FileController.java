package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@Controller
public class FileController {

    @PostMapping("/upload")
    public String upload(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        String originalFilename = file.getOriginalFilename();

        if ("".equals(originalFilename)) {
            return "redirect:/index.jsp";
        }
        System.out.println("originalFilename = " + originalFilename);

        //上传路径设置
        String path = request.getServletContext().getRealPath("/upload");
        File realPath = new File(path);
        if (!realPath.exists()) {
            boolean mkdir = realPath.mkdir();
            System.out.println(mkdir ? "创建目录" + realPath + "成功" : "创建目录失败");
        }
        file.transferTo(new File(realPath + "/" + originalFilename));
        return "redirect:/index.jsp";
    }

    @RequestMapping("/download")
    public String download(HttpServletRequest request, HttpServletResponse response) {
        //TODO
        return null;
    }
}
