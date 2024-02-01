package com.example.newSB.controller;

import com.example.newSB.DTO.ReviewDTO;
import com.example.newSB.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService)
    {
        this.reviewService=reviewService;
    }

    @PostMapping("/pokemon/{pokemonId}/review")
    public ResponseEntity<ReviewDTO> createReview(@PathVariable(value = "pokemonId") int pokid,
                                                  @RequestBody ReviewDTO reviewDTO)
    {
        return new ResponseEntity<>(reviewService.createReview(pokid,reviewDTO), HttpStatus.OK);

    }

    @GetMapping("/pokemon/{pokemonId}/reviews")
    public List<ReviewDTO> getReviewById(@PathVariable(value = "pokemonId") int pokId)
    {
        return reviewService.getReviewByPokId(pokId);
    }

    @GetMapping("/pokemon/{pokemonId}/review/{reviewId}")
    public ResponseEntity<ReviewDTO> getReviewById(@PathVariable(value = "pokemonId") int pokId,
                                                   @PathVariable(value = "reviewId") int reviewId)
    {
        ReviewDTO reviewDTO=reviewService.getReviewById(reviewId,pokId);
        return new ResponseEntity<>(reviewDTO,HttpStatus.OK);

    }
    @PutMapping("/pokemon/{pokemonId}/update/{reviewId}")
    public ResponseEntity<ReviewDTO> updateReview(@PathVariable(value = "pokemonId") int pokId,
                                                  @PathVariable(value = "reviewId") int reviewId,
                                                  @RequestBody ReviewDTO reviewDTO)
    {
        ReviewDTO reviewDTO1=reviewService.updateReview(pokId,reviewId,reviewDTO);
        return new ResponseEntity<>(reviewDTO1,HttpStatus.OK);
    }


}
