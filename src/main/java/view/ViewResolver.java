package view;

import java.util.HashMap;
import java.util.Map;

public class ViewResolver {
    private Map<String,String> pages;

    public ViewResolver() {
        pages = new HashMap<>();
        {
            pages.put(ViewConstants.PROFESSOR,PageConstants.PAGE_PROFESSOR );
            pages.put(ViewConstants.ADMIN,PageConstants.PAGE_ADMIN );
            pages.put(ViewConstants.LOGIN,PageConstants.PAGE_LOGIN );
            pages.put(ViewConstants.STUDENT,PageConstants.PAGE_STUDENT);
            pages.put(ViewConstants.SING_UP,PageConstants.PAGE_SING_UP);
        }
    }
    public String getPage(String view){
        if(pages.containsKey(view)) return pages.get(view);
        return "/";
    }

}
