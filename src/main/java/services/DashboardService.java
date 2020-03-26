package services;

import domain.Book;
import domain.dto.BookDto;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DashboardService {

    private List<Book> bookList;

    public DashboardService(List<Book> bookList) throws ParseException {
        this.bookList = new ArrayList<>();
        bookList.add(new Book("The Clean Code",
                "Robert C.", "Martin", "2008-08-15"));
        bookList.add(new Book("Animal Farm",
                "George", "Orwell", "1945-08-17"));
        bookList.add(new Book("Don Quixote",
                "Miguel", "de Cervantes", "1605-08-17"));

    }

    public List<Book> getBookList(){
        return bookList;
    }

    public Book getBookById(Long id) throws Exception {
        Optional<Book> optionalBook = bookList.stream()
                .filter(b -> b.getId().equals(id)).findFirst();
        if(optionalBook.isPresent()){
            return optionalBook.get();
        }else{
            throw new Exception("Book does not exist");
        }
    }

    public List<Book> addBook(BookDto bookDto) throws ParseException {
        Book book = new Book(bookDto.getTitle(),
                bookDto.getAuthorName(),
                bookDto.getAuthorSurname(),
                bookDto.getReleaseDate());
        bookList.add(book);
        return bookList;
    }

    public Book deleteBook(Long id) throws Exception {
        Book bookById = getBookById(id);
        bookList = bookList.stream()
                .filter(b -> !b.getId().equals(id)).collect(Collectors.toList());
        return bookById;
    }

}
