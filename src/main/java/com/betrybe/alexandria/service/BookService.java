package com.betrybe.alexandria.service;

import com.betrybe.alexandria.entity.Author;
import com.betrybe.alexandria.entity.Book;
import com.betrybe.alexandria.entity.BookDetail;
import com.betrybe.alexandria.entity.Publisher;
import com.betrybe.alexandria.repository.BookDetailRepository;
import com.betrybe.alexandria.repository.BookRepository;
import com.betrybe.alexandria.service.exception.AuthorNotFoundException;
import com.betrybe.alexandria.service.exception.BookDetailNotFoundException;
import com.betrybe.alexandria.service.exception.BookNotFoundException;
import com.betrybe.alexandria.service.exception.PublisherNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * The type Book service.
 */
@Service
public class BookService {

  private final BookRepository bookRepository;
  private final BookDetailRepository bookDetailRepository;
  private final PublisherService publisherService;
  private final AuthorService authorService;

  /**
   * Instantiates a new Book service.
   *
   * @param bookRepository       the book repository
   * @param bookDetailRepository the book detail repository
   * @param publisherService     the publisher service
   * @param authorService        the author service
   */
  @Autowired
  public BookService(
      BookRepository bookRepository,
      BookDetailRepository bookDetailRepository,
      PublisherService publisherService,
      AuthorService authorService) {
    this.bookRepository = bookRepository;
    this.bookDetailRepository = bookDetailRepository;
    this.publisherService = publisherService;
    this.authorService = authorService;
  }

  /**
   * Find by id book.
   *
   * @param id the id
   * @return the book
   * @throws BookNotFoundException the book not found exception
   */
  public Book findById(Long id) throws BookNotFoundException {
    return bookRepository.findById(id)
        .orElseThrow(BookNotFoundException::new);
  }

  /**
   * Find all list.
   *
   * @return the list
   */
  public List<Book> findAll() {
    return bookRepository.findAll();
  }

  /**
   * Create book.
   *
   * @param book the book
   * @return the book
   */
  public Book create(Book book) {
    return bookRepository.save(book);
  }

  /**
   * Update book.
   *
   * @param id   the id
   * @param book the book
   * @return the book
   * @throws BookNotFoundException the book not found exception
   */
  public Book update(Long id, Book book) throws BookNotFoundException {
    Book bookFromDb = findById(id);

    bookFromDb.setTitle(book.getTitle());
    bookFromDb.setGenre(book.getGenre());

    return bookRepository.save(bookFromDb);
  }

  /**
   * Delete by id book.
   *
   * @param id the id
   * @return the book
   * @throws BookNotFoundException the book not found exception
   */
  public Book deleteById(Long id) throws BookNotFoundException {
    Book book = findById(id);

    bookRepository.deleteById(id);

    return book;
  }

  /**
   * Create book detail.
   *
   * @param bookId     the book id
   * @param bookDetail the book detail
   * @return the book detail
   * @throws BookNotFoundException the book not found exception
   */
  public BookDetail createBookDetail(Long bookId, BookDetail bookDetail)
      throws BookNotFoundException {
    Book book = findById(bookId);

    bookDetail.setBook(book);

    return bookDetailRepository.save(bookDetail);
  }

  /**
   * Gets book detail.
   *
   * @param bookId the book id
   * @return the book detail
   * @throws BookNotFoundException       the book not found exception
   * @throws BookDetailNotFoundException the book detail not found exception
   */
  public BookDetail getBookDetail(Long bookId)
      throws BookNotFoundException, BookDetailNotFoundException {
    Book book = findById(bookId);

    BookDetail bookDetailFromDb = book.getDetail();

    if (bookDetailFromDb == null) {
      throw new BookDetailNotFoundException();
    }

    return bookDetailFromDb;
  }

  /**
   * Update book detail.
   *
   * @param bookId     the book id
   * @param bookDetail the book detail
   * @return the book detail
   * @throws BookNotFoundException       the book not found exception
   * @throws BookDetailNotFoundException the book detail not found exception
   */
  public BookDetail updateBookDetail(Long bookId, BookDetail bookDetail)
      throws BookNotFoundException, BookDetailNotFoundException {

    BookDetail bookDetailFromDb = getBookDetail(bookId);

    bookDetailFromDb.setSummary(bookDetail.getSummary());
    bookDetailFromDb.setPageCount(bookDetail.getPageCount());
    bookDetailFromDb.setYear(bookDetail.getYear());
    bookDetailFromDb.setIsbn(bookDetail.getIsbn());

    return bookDetailRepository.save(bookDetailFromDb);
  }

  /**
   * Remove book detail.
   *
   * @param bookId the book id
   * @return the book detail
   * @throws BookNotFoundException       the book not found exception
   * @throws BookDetailNotFoundException the book detail not found exception
   */
  public BookDetail removeBookDetail(Long bookId)
      throws BookNotFoundException, BookDetailNotFoundException {
    Book book = findById(bookId);
    BookDetail bookDetail = book.getDetail();

    if (bookDetail == null) {
      throw new BookDetailNotFoundException();
    }

    book.setDetail(null);
    bookDetail.setBook(null);

    bookDetailRepository.delete(bookDetail);

    return bookDetail;
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
  public Book setBookPublisher(Long bookId, Long publisherId)
      throws BookNotFoundException, PublisherNotFoundException, PublisherNotFoundException {
    Book book = findById(bookId);
    Publisher publisher = publisherService.findById(publisherId);

    book.setPublisher(publisher);

    return bookRepository.save(book);
  }

  /**
   * Remove book publisher book.
   *
   * @param bookId the book id
   * @return the book
   * @throws BookNotFoundException the book not found exception
   */
  public Book removeBookPublisher(Long bookId) throws BookNotFoundException {
    Book book = findById(bookId);

    book.setPublisher(null);

    return bookRepository.save(book);
  }

  /**
   * Add book author book.
   *
   * @param bookId   the book id
   * @param authorId the author id
   * @return the book
   * @throws BookNotFoundException   the book not found exception
   * @throws AuthorNotFoundException the author not found exception
   */
  public Book addBookAuthor(Long bookId, Long authorId)
      throws BookNotFoundException, AuthorNotFoundException {
    Book book = findById(bookId);
    Author author = authorService.findById(authorId);

    book.getAuthors().add(author);

    return bookRepository.save(book);
  }

  /**
   * Remove book author book.
   *
   * @param bookId   the book id
   * @param authorId the author id
   * @return the book
   * @throws BookNotFoundException   the book not found exception
   * @throws AuthorNotFoundException the author not found exception
   */
  public Book removeBookAuthor(Long bookId, Long authorId)
      throws BookNotFoundException, AuthorNotFoundException {
    Book book = findById(bookId);
    Author author = authorService.findById(authorId);

    book.getAuthors().remove(author);

    return bookRepository.save(book);
  }
}