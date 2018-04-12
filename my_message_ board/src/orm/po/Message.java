package orm.po;

import java.util.Date;

public class Message {
    private Integer id;

    private Integer userId;

    private Date date;

    private String title;

    private String content;
    
    private User user;
    
    public Message() {	}

    public Message(Integer userId, Date date, String title, String content) {
		super();
		this.userId = userId;
		this.date = date;
		this.title = title;
		this.content = content;
	}
    
    

	@Override
	public String toString() {
		return "Message [user=" + user + ", date=" + date + ", title=" + title + 
				", content=" + content + "]";
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}