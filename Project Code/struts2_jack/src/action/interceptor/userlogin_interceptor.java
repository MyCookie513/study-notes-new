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
			//�����Ϊ�գ������invoke()��������Ϊͨ����������
			return arg0.invoke();
		//�����ͨ�Ļ�ֱ�Ӳ����д���Action;ֱ����������action�����������������½���棻
		else return "login";
		
	}

}
