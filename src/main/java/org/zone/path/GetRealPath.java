package org.zone.path;

import javax.servlet.http.HttpServletRequest;

public class GetRealPath {
    public  static String getPath(HttpServletRequest request)
    {    System.out.println(request.getSession().getServletContext().getRealPath("/resource/txt/"));
        return request.getSession().getServletContext().getRealPath("/resource/txt/");
    }
}
