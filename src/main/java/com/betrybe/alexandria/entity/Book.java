package com.betrybe.alexandria.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Book.
 */
@Entity
@Table(name = "books")
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String title;
  private String genre;

  @OneToOne(mappedBy = "book", cascade = CascadeType.ALL)
  private BookDetail detail;

  @ManyToOne
  @JoinColumn(name = "publisher_id")
  private Publisher publisher;

  // Defines a Many-to-Many relationship
  @ManyToMany
  // Represents the intermediate table that will take care of the relationship
  @JoinTable(
      // Intermediate table name
      name = "authors_books",
      // Foreign key to the Book entity
      joinColumns = @JoinColumn(name = "book_id"),
      // Foreign key to the Author entity
      inverseJoinColumns = @JoinColumn(name = "author_id")
  )
  private List<Author> authors = new ArrayList<>();

  /**
   * Instantiates a new Book.
   */
  public Book() { }

  /**
   * Instantiates a new Book.
   *
   * @param title the title
   * @param genre the genre
   */
  public Book (String title, String genre) {
    this.genre = genre;
    this.title = title;
  }

  /**
   * Gets id.
   *
   * @return the id
   */
  public long getId() {
    return id;
  }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Gets title.
   *
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * Sets title.
   *
   * @param title the title
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * Gets genre.
   *
   * @return the genre
   */
  public String getGenre() {
    return genre;
  }

  /**
   * Sets genre.
   *
   * @param genre the genre
   */
  public void setGenre(String genre) {
    this.genre = genre;
  }

  /**
   * Gets detail.
   *
   * @return the detail
   */
  public BookDetail getDetail() {
    return detail;
  }

  /**
   * Sets detail.
   *
   * @param detail the detail
   */
  public void setDetail(BookDetail detail) {
    this.detail = detail;
  }

  /**
   * Gets publisher.
   *
   * @return the publisher
   */
  public Publisher getPublisher() {
    return publisher;
  }

  /**
   * Sets publisher.
   *
   * @param publisher the publisher
   */
  public void setPublisher(Publisher publisher) {
    this.publisher = publisher;
  }

  /**
   * Gets authors.
   *
   * @return the authors
   */
  public List<Author> getAuthors() {
    return authors;
  }

  /**
   * Sets authors.
   *
   * @param authors the authors
   */
  public void setAuthors(List<Author> authors) {
    this.authors = authors;
  }
}
