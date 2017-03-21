package remote;

import java.io.Serializable;

public class RCall implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9014650359176226910L;

	private String className;
	private String methodName;
	private Class[] paramsType;
	private Object[] params;
	
	private Object result;
	public RCall(){
		
	}
	public RCall(String className, String methodName, Class[] paramsType, Object[] params) {
		this.className = className;
		this.methodName = methodName;
		this.paramsType = paramsType;
		this.params = params;
	}


	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public Class[] getParamsType() {
		return paramsType;
	}

	public void setParamsType(Class[] paramsType) {
		this.paramsType = paramsType;
	}

	public Object[] getParams() {
		return params;
	}

	public void setParams(Object[] params) {
		this.params = params;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
	//÷ÿ–¥toString,∑Ω±„ ‰≥ˆ
	@Override
	public String toString(){
		return "className:"+className+",methodName:"+methodName;
	}

	
}
