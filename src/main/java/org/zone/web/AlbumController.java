package org.zone.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.zone.entity.Album;
import org.zone.entity.User;
import org.zone.service.AlbumService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class AlbumController {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AlbumService albumService;
    @RequestMapping(value = "/album/{username}",method = RequestMethod.GET)
    public String album(Model model, @PathVariable("username")String username, HttpSession session)
    {    User user= (User) session.getAttribute("user");
        if(!username.equals(user.getUsername()))
        {   logger.error("错误的username"+username+"session中的"+user.getUsername());
            return "redirect:/login";
        }
        return "album";
    }
    @RequestMapping(value = "/albumsl/{username}",method = RequestMethod.GET)
    public String albumsl(Model model, @PathVariable("username")String username, HttpSession session)
    {    User user= (User) session.getAttribute("user");
        if(!username.equals(user.getUsername()))
        {   logger.error("错误的username"+username+"session中的"+user.getUsername());
            return "redirect:/login";
        }
        List<Album> album=albumService.queryAll(user.getUsername());
        model.addAttribute("album",album);
        return "albumsl";
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String upload(@RequestParam("file") MultipartFile[] file,@RequestParam("infor")String infor,@RequestParam("caption")String caption,
                         HttpServletRequest request,HttpSession session) throws IOException {
        User user= (User) session.getAttribute("user");
        String path = request.getSession().getServletContext().getRealPath("../../src/main/webapp/resource/image/album");
       System.out.println(path);
        for (int i = 0; i < file.length; i++) {
            String fileName = file[i].getOriginalFilename();
            File dir = new File(path, fileName);
            if (!dir.exists()) {
                dir.mkdirs();
                file[i].transferTo(dir);
            }
        if(infor.equals("")||caption.equals("")||fileName.equals(""))
        {
            return "redirect:/album/"+user.getUsername();
        }
            //MultipartFile自带的解析方法
            albumService.insert(user.getUsername(),"/resource/image/album/"+fileName,infor,caption);
        }

        System.out.println("上传成功!"+path);
        return "redirect:/album/"+user.getUsername();
    }
}
