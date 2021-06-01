package Exception;

import java.util.Date;

public class ExceptionController {
	
    //timeStamp
	private Date timestamp;
	
	//message
	private String message;
	
	//details
	private String details;
	
	public ExceptionController() {
		super();
	}

	public ExceptionController(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}


	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}


	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "ExceptionResponse [timestamp=" + timestamp + ", message=" + message + ", details=" + details + "]";
	}
	
	
	
	
	
}
