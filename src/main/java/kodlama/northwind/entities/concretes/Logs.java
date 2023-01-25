package kodlama.northwind.entities.concretes;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import kodlama.northwind.core.entities.User;

@Entity
@Table(	name = "logs")
public class Logs {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Logid")
	private int Id;
	
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date")
    private Date date;
	
	
	@Column(name="level")
	private String level;
	
	
	@Column(name="message")
	private String message;
	
	@ManyToOne()
    @JoinColumn(name = "id")
	private User user;

	public Logs() {
	
	}

	public Logs(int id, User user, Date date, String level, String message) {
		super();
		Id = id;
		this.user = user;
		this.date = date;
		this.level = level;
		this.message = message;
	}


	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
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

	

	
	
	
	

}
