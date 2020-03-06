package org.zone.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zone.dao.WordDao;
import org.zone.entity.Word;
import org.zone.service.WordService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

import static org.zone.file.WriteStringToTxt.readTxt;
import static org.zone.path.GetRealPath.getPath;

@Service
public class WordServiceImpl implements WordService {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private WordDao wordDao;

    public List<Word> queryByUsername(String username,HttpServletRequest request) {
        List<Word> words= wordDao.queryAll(username);
        String[] txt=new String[words.size()];
        String[] word=new String[words.size()];
        String path =getPath(request);
        for(int i=0;i<txt.length;i++)
        {
            txt[i]=path+"/"+words.get(i).getWord();
            word[i]=readTxt(txt[i]);
            words.get(i).setWord(word[i]);
        }
        return words;
    }

    public void insert(String username, String word) {
        wordDao.insert(username,word);
    }

    public void delete(int id,HttpServletRequest request) {
          String path=getPath(request);
          Word word=wordDao.queryById(id);
        File file=new File(path+"/"+word.getWord());
        if(file.exists()&&file.isFile())
        {
            file.delete();
            }
        wordDao.delete(id);
        }

    public int count() {
        return wordDao.count();
    }
}
