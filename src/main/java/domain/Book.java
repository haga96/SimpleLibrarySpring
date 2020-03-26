package domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Id;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@ToString
@Data
public class Book {

    @Id
    private Long id;
    private String title;
    private String authorName;
    private String authorSurname;
    private Date releaseDate;

    public Book(String title, String authorName, String authorSurname, String releaseDate) throws ParseException {
        this.title = title;
        this.authorName = authorName;
        this.authorSurname = authorSurname;
        this.releaseDate = parseDate(releaseDate);
    }

    private Date parseDate(String releaseDate) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.parse(releaseDate);
    }
}