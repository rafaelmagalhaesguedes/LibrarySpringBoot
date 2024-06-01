package com.betrybe.alexandria.controller;

import com.betrybe.alexandria.controller.dto.BookCreationDto;
import com.betrybe.alexandria.controller.dto.BookDetailCreationDto;
import com.betrybe.alexandria.controller.dto.BookDetailDto;
import com.betrybe.alexandria.controller.dto.BookDto;
import com.betrybe.alexandria.entity.Book;
import com.betrybe.alexandria.service.BookService;
import com.betrybe.alexandria.service.exception.AuthorNotFoundException;
import com.betrybe.alexandria.service.exception.BookDetailNotFoundException;
import com.betrybe.alexandria.service.exception.BookNotFoundException;
import com.betrybe.alexandria.service.exception.PublisherNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Book controller.
 */
@RestController
@RequestMapping(value = "/books")
public class BookController {

  private final BookService bookService;

  /**
   * Instantiates a new Book controller.
   *
   * @param bookService the book service
   */
  @Autowired
  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  /**
   * Gets book by id.
   *
   * @param id the id
   * @return the book by id
   * @throws BookNotFoundException the book not found exception
   */
  @GetMapping("/{id}")
  public BookDto getBookById(@PathVariable Long id) throws BookNotFoundException {
    return BookDto.fromEntity(
        bookService.findById(id)
    );
  }

  /**
   * Gets all books.
   *
   * @return the all books
   */
  @GetMapping
  public List<BookDto> getAllBooks() {
    List<Book> allBooks = bookService.findAll();
    return allBooks.stream()
        .map(BookDto::fromEntity)
        .toList();
  }

  /**
   * Create book dto.
   *
   * @param bookCreationDto the book creation dto
   * @return the book dto
   */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public BookDto createBook(@RequestBody BookCreationDto bookCreationDto) {
    return BookDto.fromEntity(
        bookService.create(bookCreationDto.toEntity())
    );
  }

  /**
   * Update book dto.
   *
   * @param id              the id
   * @param bookCreationDto the book creation dto
   * @return the book dto
   * @throws BookNotFoundException the book not found exception
   */
  @PutMapping("/{id}")
  public BookDto updateBook(@PathVariable Long id,
      @RequestBody BookCreationDto bookCreationDto) throws BookNotFoundException {
    return BookDto.fromEntity(
        bookService.update(id, bookCreationDto.toEntity())
    );
  }

  /**
   * Delete book by id book dto.
   *
   * @param id the id
   * @return the book dto
   * @throws BookNotFoundException the book not found exception
   */
  @DeleteMapping("/{id}")
  public BookDto deleteBookById(@PathVariable Long id) throws BookNotFoundException {
    return BookDto.fromEntity(
        bookService.deleteById(id)
    );
  }

  /**
   * Create book detail book detail dto.
   *
   * @param bookId                the book id
   * @param bookDetailCreationDto the book detail creation dto
   * @return the book detail dto
   * @throws BookNotFoundException the book not found exception
   */
  @PostMapping("/{bookId}/detail")
  @ResponseStatus(HttpStatus.CREATED)
  public BookDetailDto createBookDetail(@PathVariable Long bookId,
      @RequestBody BookDetailCreationDto bookDetailCreationDto)
    throws BookNotFoundException {
    return BookDetailDto.fromEntity(
        bookService.createBookDetail(bookId, bookDetailCreationDto.toEntity())
    );
  }

  /**
   * Gets book detail.
   *
   * @param bookId the book id
   * @return the book detail
   * @throws BookNotFoundException       the book not found exception
   * @throws BookDetailNotFoundException the book detail not found exception
   */
  @GetMapping("/{bookId}/detail")
  public BookDetailDto getBookDetail(@PathVariable Long bookId)
      throws BookNotFoundException, BookDetailNotFoundException {
    return BookDetailDto.fromEntity(
        bookService.getBookDetail(bookId)
    );
  }

  /**
   * Update book detail book detail dto.
   *
   * @param bookId                the book id
   * @param bookDetailCreationDto the book detail creation dto
   * @return the book detail dto
   * @throws BookDetailNotFoundException the book detail not found exception
   * @throws BookNotFoundException       the book not found exception
   */
  @PutMapping("/{bookId}/detail")
  public BookDetailDto updateBookDetail(@PathVariable Long bookId,
      @RequestBody BookDetailCreationDto bookDetailCreationDto)
      throws BookDetailNotFoundException, BookNotFoundException {
    return BookDetailDto.fromEntity(
        bookService.updateBookDetail(bookId, bookDetailCreationDto.toEntity())
    );
  }

  /**
   * Remove book detail book detail dto.
   *
   * @param bookId the book id
   * @return the book detail dto
   * @throws BookDetailNotFoundException the book detail not found exception
   * @throws BookNotFoundException       the book not found exception
   */
  @DeleteMapping("/{bookId}/detail")
  public BookDetailDto removeBookDetail(@PathVariable Long bookId)
      throws BookDetailNotFoundException, BookNotFoundException {
    return BookDetailDto.fromEntity(
        bookService.removeBookDetail(bookId)
    );
  }

  /**
   * Sets book publisher.
   *
   * @param bookId      the book id
   * @param publisherId the publisher id
   * @return the book publisher
   * @throws BookNotFoundException      the book not found exception
   * @throws PublisherNotFoundException the publisher not found exception
   * @throws PublisherNotFoundException the publisher not found exception
   */
  @PutMapping("/{bookId}/publisher/{publisherId}")
  public BookDto setBookPublisher(@PathVariable Long bookId,
      @PathVariable Long publisherId)
      throws BookNotFoundException, PublisherNotFoundException, PublisherNotFoundException {
    return BookDto.fromEntity(
        bookService.setBookPublisher(bookId, publisherId)
    );
  }

  /**
   * Remove book publisher book dto.
   *
   * @param bookId the book id
   * @return the book dto
   * @throws BookNotFoundException the book not found exception
   */
  @DeleteMapping("/{bookId}/publisher")
  public BookDto removeBookPublisher(@PathVariable Long bookId) throws BookNotFoundException {
    return BookDto.fromEntity(
        bookService.removeBookPublisher(bookId)
    );
  }

  /**
   * Add book author book dto.
   *
   * @param bookId   the book id
   * @param authorId the author id
   * @return the book dto
   * @throws AuthorNotFoundException the author not found exception
   * @throws BookNotFoundException   the book not found exception
   */
  @PostMapping("/{bookId}/authors/{authorId}")
  public BookDto addBookAuthor(@PathVariable Long bookId, @PathVariable Long authorId)
    throws AuthorNotFoundException, BookNotFoundException {
    return BookDto.fromEntity(
        bookService.addBookAuthor(bookId, authorId)
    );
  }

  /**
   * Remove book author book dto.
   *
   * @param bookId   the book id
   * @param authorId the author id
   * @return the book dto
   * @throws AuthorNotFoundException the author not found exception
   * @throws BookNotFoundException   the book not found exception
   */
  @DeleteMapping("/{bookId}/authors/{authorId}")
  public BookDto removeBookAuthor(@PathVariable Long bookId, @PathVariable Long authorId)
    throws AuthorNotFoundException, BookNotFoundException {
    return BookDto.fromEntity(
        bookService.removeBookAuthor(bookId, authorId)
    );
  }
}