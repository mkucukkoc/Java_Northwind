package kodlama.northwind.core.logging;

public class LogParameter {

	public String Name;
	public String Type;
	public Object Value;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public Object getValue() {
		return Value;
	}
	public void setValue(Object value) {
		Value = value;
	}

	
}
