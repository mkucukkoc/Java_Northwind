package kodlama.northwind.entities.dtos;

import java.util.Date;

public class LogDtoWithUserId {


	private int Id;
    private Date date;
	private String level;
	private String message;
	private Long userId;
	
	
	public LogDtoWithUserId() {
		
	}
	public LogDtoWithUserId(int id, Date date, String level, String message, Long userId) {
		super();
		Id = id;
		this.date = date;
		this.level = level;
		this.message = message;
		this.userId = userId;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
