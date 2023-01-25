package kodlama.northwind.core.logging;

import java.util.List;

public class LogDetails {

	public String FullName;
	public String MethodName;
	public List<LogParameter> parameters;
	
	
	public String getFullName() {
		return FullName;
	}
	public void setFullName(String fullName) {
		FullName = fullName;
	}
	public String getMethodName() {
		return MethodName;
	}
	public void setMethodName(String methodName) {
		MethodName = methodName;
	}
	public List<LogParameter> getParameters() {
		return parameters;
	}
	public void setParameters(List<LogParameter> parameters) {
		this.parameters = parameters;
	}
	
}
