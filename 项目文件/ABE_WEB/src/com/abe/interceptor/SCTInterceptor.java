package com.abe.interceptor;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.util.HtmlUtils;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @author 张顺
 *<br>2017-1-12
 *<br>特殊字符转换拦截器,同时对所有参数进行去首位空格处理，以后action的clearSpace方法可以去掉了（前拦截器）
 */
public class SCTInterceptor extends AbstractInterceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger=Logger.getLogger(SCTInterceptor.class);
	
	
	
	
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		Map map=arg0.getInvocationContext().getParameters();  
        Set keys = map.keySet();  
                  Iterator iters = keys.iterator();  
                while(iters.hasNext()){  
                    Object key = iters.next();  
                    Object value = map.get(key);  
                    map.put(key, transfer((String[])value));  
                }  
        return arg0.invoke();  
	}
	
	private String[] transfer(String[] params){  
        for(int i=0;i<params.length;i++){  
            if(StringUtils.isEmpty(params[i]))continue;  
            params[i]=params[i].trim();  
            params[i]=HtmlUtils.htmlEscape(params[i]);
        }  
        return params;  
    }    
}
