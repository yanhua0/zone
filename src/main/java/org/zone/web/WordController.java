package org.zone.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.zone.entity.User;
import org.zone.entity.Word;
import org.zone.file.WriteStringToTxt;
import org.zone.service.WordService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static org.zone.file.WriteStringToTxt.WriteStringToFile5;
import static org.zone.path.GetRealPath.getPath;

@Controller
public class WordController {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private WordService wordService;
    @RequestMapping(value = "/zone/{username}",method = RequestMethod.GET)
    public String zone(Model model,@PathVariable("username")String username, HttpSession session,HttpServletRequest request)
    {   User user= (User) session.getAttribute("user");
        if(!username.equals(user.getUsername()))
        {   logger.error("错误的username"+username+"session中的"+user.getUsername());
            return "redirect:/login";
        }
        List<Word> word=wordService.queryByUsername(username,request);
        model.addAttribute("word",word);
        return "zone";
    }
    @RequestMapping(value = "/fabu",method = RequestMethod.POST)
    @ResponseBody
    public void fabu(HttpSession session, @RequestParam("word")String word,HttpServletRequest request)
    {
        try{
            User user= (User) session.getAttribute("user");
            int count=wordService.count();
            String name= String.valueOf(count+1)+".txt";
            String path =getPath(request)+"/"+name;
            logger.info("文本内容1:"+path);
            WriteStringToFile5(path,word);
            wordService.insert(user.getUsername(),name);
        }catch (Exception e)
        {
            logger.error(e.getMessage());
        }

    }
    @RequestMapping(value = "/del",method = RequestMethod.POST)
    @ResponseBody
    public void del(HttpSession session, @RequestParam("id")int id,HttpServletRequest request)
    {   User user= (User) session.getAttribute("user");
        wordService.delete(id,request);
    }

}
