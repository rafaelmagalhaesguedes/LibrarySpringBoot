package com.betrybe.alexandria.controller.dto;

import com.betrybe.alexandria.entity.Publisher;

/**
 * The type Publisher dto.
 */
public record PublisherDto(Long Id, String name, String address) {

  /**
   * From entity publisher dto.
   *
   * @param publisher the publisher
   * @return the publisher dto
   */
  public static PublisherDto fromEntity(Publisher publisher) {
    return new PublisherDto(
        publisher.getId(),
        publisher.getName(),
        publisher.getAddress()
    );
  }
}
