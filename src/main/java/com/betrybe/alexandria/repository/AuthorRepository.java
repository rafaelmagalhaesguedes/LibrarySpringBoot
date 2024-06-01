package com.betrybe.alexandria.repository;

import com.betrybe.alexandria.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Author repository.
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
