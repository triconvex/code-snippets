package 더자바_코드를조작하는다양한방법.mydi;

import org.junit.Test;

import static org.junit.Assert.*;

public class ContainerServiceTest {

    @Test
    public void getObejct_BookRepository() {
        BookRepository bookRepository = ContainerService.getObject(BookRepository.class);
        assertNotNull(bookRepository);
    }

    @Test
    public void getObejct_BookService() {
        BookService bookService = ContainerService.getObject(BookService.class);
        assertNotNull(bookService);
        assertNotNull(bookService.bookRepository);
    }

}