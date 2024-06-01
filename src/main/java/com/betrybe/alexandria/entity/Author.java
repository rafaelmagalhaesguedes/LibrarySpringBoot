package com.betrybe.alexandria.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 * The type Author.
 */
@Entity
@Table(name = "authors")
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String name;
  private String nationality;

  // Reverse mapping
  @ManyToMany(mappedBy = "authors")
  private List<Book> books;

  /**
   * Instantiates a new Author.
   */
  public Author() { }

  /**
   * Instantiates a new Author.
   *
   * @param name        the name
   * @param nationality the nationality
   */
  public Author(String name, String nationality) {
    this.name = name;
    this.nationality = nationality;
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
   * Gets name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets name.
   *
   * @param name the name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets nationality.
   *
   * @return the nationality
   */
  public String getNationality() {
    return nationality;
  }

  /**
   * Sets nationality.
   *
   * @param nationality the nationality
   */
  public void setNationality(String nationality) {
    this.nationality = nationality;
  }

  /**
   * Gets books.
   *
   * @return the books
   */
  public List<Book> getBooks() {
    return books;
  }

  /**
   * Sets books.
   *
   * @param books the books
   */
  public void setBooks(List<Book> books) {
    this.books = books;
  }
}
