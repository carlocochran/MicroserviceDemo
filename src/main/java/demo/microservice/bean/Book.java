package demo.microservice.bean;

public class Book {
	private Integer id;
	private String title;
	private String author;
	private Float price;

	public Book(Integer id, String title, String author, Float price) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}