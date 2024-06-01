package com.betrybe.alexandria.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 * The type Publisher.
 */
@Entity
@Table(name = "publishers")
public class Publisher {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String name;
  private String address;

  @OneToMany(mappedBy = "publisher")
  private List<Book> books;

  /**
   * Instantiates a new Publisher.
   */
  public Publisher() {

  }

  /**
   * Instantiates a new Publisher.
   *
   * @param name    the name
   * @param address the address
   */
  public Publisher(String name, String address) {
    this.name = name;
    this.address = address;
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
   * Gets address.
   *
   * @return the address
   */
  public String getAddress() {
    return address;
  }

  /**
   * Sets address.
   *
   * @param address the address
   */
  public void setAddress(String address) {
    this.address = address;
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
