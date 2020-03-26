package controller;

import domain.Book;
import domain.dto.BookDto;
import org.springframework.web.bind.annotation.*;
import services.DashboardService;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    private DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping
    public List<Book> getBookList(){
        return dashboardService.getBookList();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) throws Exception {
        return dashboardService.getBookById(id);
    }

    @PostMapping
    public List<Book> addBook(@RequestBody BookDto bookDto) throws ParseException {
        return dashboardService.addBook(bookDto);
    }

    @DeleteMapping("{id}")
    public Book deleteBook(@PathVariable Long id) throws Exception {
        return dashboardService.deleteBookById(id);
    }
}
