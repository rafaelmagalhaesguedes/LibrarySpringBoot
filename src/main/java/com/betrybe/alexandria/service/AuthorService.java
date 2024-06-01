package com.betrybe.alexandria.service;

import com.betrybe.alexandria.entity.Author;
import com.betrybe.alexandria.repository.AuthorRepository;
import com.betrybe.alexandria.service.exception.AuthorNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Author service.
 */
@Service
public class AuthorService {

  private final AuthorRepository authorRepository;

  /**
   * Instantiates a new Author service.
   *
   * @param authorRepository the author repository
   */
  @Autowired
  public AuthorService(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  /**
   * Find by id author.
   *
   * @param id the id
   * @return the author
   * @throws AuthorNotFoundException the author not found exception
   */
  public Author findById(Long id) throws AuthorNotFoundException {
    return authorRepository.findById(id)
        .orElseThrow(AuthorNotFoundException::new);
  }

  /**
   * Find all list.
   *
   * @return the list
   */
  public List<Author> findAll() {
    return authorRepository.findAll();
  }

  /**
   * Create author.
   *
   * @param author the author
   * @return the author
   */
  public Author create(Author author) {
    return authorRepository.save(author);
  }

  /**
   * Update author.
   *
   * @param id     the id
   * @param author the author
   * @return the author
   * @throws AuthorNotFoundException the author not found exception
   */
  public Author update(Long id, Author author) throws AuthorNotFoundException {
    Author authorFromDb = findById(id);

    authorFromDb.setName(author.getName());
    authorFromDb.setNationality(author.getNationality());

    return authorRepository.save(authorFromDb);
  }

  /**
   * Delete by id author.
   *
   * @param id the id
   * @return the author
   * @throws AuthorNotFoundException the author not found exception
   */
  public Author deleteById(Long id) throws AuthorNotFoundException {
    Author author = findById(id);

    authorRepository.deleteById(id);

    return author;
  }
}
