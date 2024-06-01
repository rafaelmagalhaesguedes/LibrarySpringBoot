package com.betrybe.alexandria.service;

import com.betrybe.alexandria.entity.Publisher;
import com.betrybe.alexandria.repository.PublisherRepository;
import com.betrybe.alexandria.service.exception.PublisherNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Publisher service.
 */
@Service
public class PublisherService {

  private final PublisherRepository publisherRepository;

  /**
   * Instantiates a new Publisher service.
   *
   * @param publisherRepository the publisher repository
   */
  @Autowired
  public PublisherService(PublisherRepository publisherRepository) {
    this.publisherRepository = publisherRepository;
  }

  /**
   * Find by id publisher.
   *
   * @param id the id
   * @return the publisher
   * @throws PublisherNotFoundException the publisher not found exception
   */
  public Publisher findById(Long id) throws PublisherNotFoundException {
    return publisherRepository.findById(id)
        .orElseThrow(PublisherNotFoundException::new);
  }

  /**
   * Find all list.
   *
   * @return the list
   */
  public List<Publisher> findAll() {
    return publisherRepository.findAll();
  }

  /**
   * Create publisher.
   *
   * @param publisher the publisher
   * @return the publisher
   */
  public Publisher create(Publisher publisher) {
    return publisherRepository.save(publisher);
  }

  /**
   * Update publisher.
   *
   * @param id        the id
   * @param publisher the publisher
   * @return the publisher
   * @throws PublisherNotFoundException the publisher not found exception
   */
  public Publisher update(Long id, Publisher publisher) throws PublisherNotFoundException {
    Publisher publisherFromDb = findById(id);

    publisherFromDb.setName(publisher.getName());
    publisherFromDb.setAddress(publisher.getAddress());

    return publisherRepository.save(publisherFromDb);
  }

  /**
   * Delete by id publisher.
   *
   * @param id the id
   * @return the publisher
   * @throws PublisherNotFoundException the publisher not found exception
   */
  public Publisher deleteById(Long id) throws PublisherNotFoundException {
    // Pegamos a entidade antes de apagar, para poder retorná-la
    Publisher publisher = findById(id);

    publisherRepository.deleteById(id);

    return publisher;
  }
}
