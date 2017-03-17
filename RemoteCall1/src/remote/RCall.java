package remote;
import java.io.Serializable;

/**
 * 
 * @author GQB1226
 *
 */
public class RCall implements Serializable{
	
	
	private String className;
	private String methodName;
	private Class[] paramTypes;//方法参数类型
	private Object[] params;
	private Object result;
	
	
	public RCall(String className, String methodName, Class[] paramTypes, Object[] params) {
		this.className = className;
		this.methodName = methodName;
		this.paramTypes = paramTypes;
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
	public Class[] getParamTypes() {
		return paramTypes;
	}
	public void setParamTypes(Class[] paramTypes) {
		this.paramTypes = paramTypes;
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
	
	//重写toString,方便输出
	@Override
	public String toString(){
		return "className:"+className+",methodName:"+methodName;
	}
	

}
