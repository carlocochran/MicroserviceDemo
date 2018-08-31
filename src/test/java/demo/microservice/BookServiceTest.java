package demo.microservice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import demo.microservice.bean.Book;
import demo.microservice.bean.Status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { Application.class })
public class BookServiceTest {

	@Autowired
	private BookService service;

	@Test
	public void testAddBook() {
		Book book = new Book(99, "New Book", "New Author", 39.95f);
		Status status = service.addBook(book);
		assertEquals(status.getStatusCode(), Status.Code.SUCCESS);
		Book newBook = service.getBook(99);
		assertEquals(newBook.getTitle(), "New Book");
		assertEquals(newBook.getAuthor(), "New Author");
		assertEquals(newBook.getPrice(), new Float(39.95));
	}

	@Test
	public void testGetBook() {
		Book newBook = service.getBook(1);
		assertNotNull(newBook);
		assertEquals(newBook.getTitle(), "The Great Gatsby");
		assertEquals(newBook.getAuthor(), "F. Scott Fitzgerald");
		assertEquals(newBook.getPrice(), new Float(19.95f));
	}

	@Test
	public void testDeleteBook() {
		Status status = service.deleteBook(2);
		assertEquals(status.getStatusCode(), Status.Code.SUCCESS);
		Book newBook = service.getBook(2);
		assertNull(newBook);
	}

	@Test
	public void testListAllBooks() {
		List<Book> bookList = service.listAllBooks();
		assertNotNull(bookList);
	}
}
