package com.example.newSB.service;

import com.example.newSB.DTO.ReviewDTO;

import java.util.List;

public interface ReviewService {

    ReviewDTO createReview(int pokId,ReviewDTO reviewDTO);

    List<ReviewDTO> getReviewByPokId(int id);

    ReviewDTO getReviewById(int reviewId,int pokId);

    ReviewDTO updateReview(int pokId,int reviewId,ReviewDTO reviewDTO);
}
