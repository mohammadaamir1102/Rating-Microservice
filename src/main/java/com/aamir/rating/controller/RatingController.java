package com.aamir.rating.controller;

import com.aamir.rating.dto.PaginationDTO;
import com.aamir.rating.entity.Rating;
import com.aamir.rating.exception.ResourceNotFoundException;
import com.aamir.rating.exception.ServiceException;
import com.aamir.rating.service.RatingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/rating")
@RestController
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/saveRating")
    public ResponseEntity<Rating> saveRating(@RequestBody Rating rating) {
        log.info("/* inside the RatingController, rating {} */ ", rating);
        Rating saveRating = ratingService.saveRating(rating);
        log.info("/* saved Successfully, rating {} */ ", saveRating);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveRating);
    }

    @GetMapping("/findAllRating")
    public ResponseEntity<List<Rating>> findAllRating() {
        List<Rating> ratings = ratingService.findAllRating();
        log.info("/* rating {} */ ", ratings);
        return ResponseEntity.status(HttpStatus.OK).body(ratings);
    }

    @GetMapping("/findByRatingId/{ratingId}")
    public ResponseEntity<Rating> findByRatingId(@PathVariable Long ratingId) throws ResourceNotFoundException {
        log.info("/* rating id  {} */ ", ratingId);
        Rating rating = ratingService.findById(ratingId);
        log.info("/* rating data {} */ ", rating);
        return ResponseEntity.status(HttpStatus.OK).body(rating);
    }

    @GetMapping("/findAllRatings/{page}/{offset}")
    public ResponseEntity<Map> findAllRatings(@PathVariable Long page, @PathVariable Long offset) throws ServiceException {
        PaginationDTO paginationDTO = new PaginationDTO();
        paginationDTO.setPageNumber(page.intValue());
        paginationDTO.setOffset(offset.intValue());
        log.info("/* pagination is  {} */ ", paginationDTO);
        Map allRatings = ratingService.findAllRatings(paginationDTO);
        log.info("/* all ratings {} */ ", allRatings);
        return ResponseEntity.status(HttpStatus.OK).body(allRatings);
    }

    @GetMapping("/userId/{userId}")
    public ResponseEntity<List<Rating>> findRatingByUserId(Long userId) {
        List<Rating> ratingByUserId = ratingService.findRatingByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(ratingByUserId);
    }

    @GetMapping("/hotelId/{hotelId}")
    public ResponseEntity<List<Rating>> findRatingByHotelId(@PathVariable Long hotelId) {
        List<Rating> ratingByHotelId = ratingService.findRatingByUserId(hotelId);
        return ResponseEntity.status(HttpStatus.OK).body(ratingByHotelId);
    }


}
