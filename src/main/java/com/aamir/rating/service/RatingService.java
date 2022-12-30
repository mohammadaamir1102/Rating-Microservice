package com.aamir.rating.service;

import com.aamir.rating.dto.PaginationDTO;
import com.aamir.rating.entity.Rating;
import com.aamir.rating.exception.ResourceNotFoundException;
import com.aamir.rating.exception.ServiceException;

import java.util.List;
import java.util.Map;

public interface RatingService {

    Rating saveRating(Rating rating);

    List<Rating> findAllRating();

    Rating findById(Long ratingId) throws ResourceNotFoundException;

    Map findAllRatings(PaginationDTO paginationDTO) throws ServiceException;

    List<Rating> findRatingByUserId(Long userId);

    List<Rating> findRatingByHotelId(Long hotelId);
}
