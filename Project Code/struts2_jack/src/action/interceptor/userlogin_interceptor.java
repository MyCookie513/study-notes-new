package action.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class userlogin_interceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		
		ActionContext actioncontex=arg0.getInvocationContext();
		//d
		Map<String, Object> param=actioncontex.getParameters();
		String username =param.get("username").toString();
		if(!username.equals(""))
			//如果不为空，则调用invoke()方法；即为通过拦截器；
			return arg0.invoke();
		//如果不通的话直接不进行处理Action;直接跳到处理action处理结果，进而进入登陆界面；
		else return "login";
		
	}

}
