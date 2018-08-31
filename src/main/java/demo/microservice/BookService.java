package demo.microservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import demo.microservice.bean.Book;
import demo.microservice.bean.Status;
import demo.microservice.bean.Status.Code;

@RestController
public class BookService {

	private Map<Integer, Book> bookMap = new HashMap<Integer, Book>();
	{
		bookMap.put(1, new Book(1, "The Great Gatsby", "F. Scott Fitzgerald", 19.95f));
		bookMap.put(2, new Book(2, "The Old Man and the Sea", "Ernest Hemmingway", 10.00f));
		bookMap.put(3, new Book(3, "The Odyssey", "Homer", 9.95f));
	}

	@RequestMapping(value = "/book/add", method = RequestMethod.POST)
	public Status addBook(@RequestBody Book book) {
		Code status = Code.SUCCESS;
		try {
			bookMap.put(book.getId(), book);
		}
		catch (Exception ex) {
			status = Code.FAILED;
		}
		return new Status(status);
	}

	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Book getBook(@PathVariable("id") Integer id) {
		return bookMap.get(id);
	}

	@RequestMapping(value = "/book/delete/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Status deleteBook(@PathVariable("id") Integer id) {
		Code status = Code.SUCCESS;
		try {
			bookMap.remove(id);
		}
		catch (Exception ex) {
			status = Code.FAILED;
		}
		return new Status(status);
	}

	@RequestMapping(value = "/book/list", method = RequestMethod.GET)
	@ResponseBody
	public List<Book> listAllBooks() {
		return new ArrayList<Book>(bookMap.values());
	}
}