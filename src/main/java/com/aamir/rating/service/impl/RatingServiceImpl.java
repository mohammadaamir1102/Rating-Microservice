package com.aamir.rating.service.impl;

import com.aamir.rating.dto.PaginationDTO;
import com.aamir.rating.entity.Rating;
import com.aamir.rating.exception.ResourceNotFoundException;
import com.aamir.rating.exception.ServiceException;
import com.aamir.rating.repo.RatingRepository;
import com.aamir.rating.service.PaginationService;
import com.aamir.rating.service.RatingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private PaginationService paginationService;

    @Override
    public Rating saveRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> findAllRating() {
        return ratingRepository.findAll();
    }

    @Override
    public Rating findById(Long ratingId) throws ResourceNotFoundException {
        return ratingRepository.findById(ratingId).orElseThrow(
                () -> new ResourceNotFoundException("Rating id: " + ratingId + " is not Exist !"));
    }

    @Override
    public Map findAllRatings(PaginationDTO paginationDTO) throws ServiceException {
        Page<Rating> ratings = ratingRepository.findAll(paginationService.getPagination(paginationDTO));
        log.info("/* rating records {} */", ratings);
        Map<String, Object> datamap = new HashMap<>();
        datamap.put("data", ratings);
        datamap.put("totalPage", ratings.getTotalPages());
        datamap.put("currentPage", ratings.getNumber());
        datamap.put("currentPage", ratings.getNumber());
        datamap.put("totalRecords", ratings.getSize());
        return datamap;
    }

    @Override
    public List<Rating> findRatingByUserId(Long userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> findRatingByHotelId(Long hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }
}
