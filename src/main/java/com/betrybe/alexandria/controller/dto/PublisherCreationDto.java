package com.betrybe.alexandria.controller.dto;

import com.betrybe.alexandria.entity.Publisher;

/**
 * The type Publisher creation dto.
 */
public record PublisherCreationDto(String name, String address) {

  /**
   * To entity publisher.
   *
   * @return the publisher
   */
  public Publisher toEntity() {
    return new Publisher(name, address);
  }
}
