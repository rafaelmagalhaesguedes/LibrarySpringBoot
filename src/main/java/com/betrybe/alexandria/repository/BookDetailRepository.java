package com.betrybe.alexandria.repository;

import com.betrybe.alexandria.entity.BookDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Book detail repository.
 */
@Repository
public interface BookDetailRepository extends JpaRepository<BookDetail, Long> {

}
