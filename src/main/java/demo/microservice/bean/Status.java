package demo.microservice.bean;

public class Status {
	public enum Code {
		SUCCESS, FAILED
	}

	private Code statusCode;

	public Status(Code statusCode) {
		this.statusCode = statusCode;
	}

	public Code getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Code statusCode) {
		this.statusCode = statusCode;
	}
}
