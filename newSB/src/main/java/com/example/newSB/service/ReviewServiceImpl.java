package com.example.newSB.service;

import com.example.newSB.DTO.PokemonDTO;
import com.example.newSB.DTO.ReviewDTO;
import com.example.newSB.entity.Pokemon;
import com.example.newSB.entity.Review;
import com.example.newSB.exception.PokemonNotFound;
import com.example.newSB.exception.ReviewNotFoundException;
import com.example.newSB.repository.PokemnRepo;
import com.example.newSB.repository.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService{


    private ReviewRepo reviewRepo;
    private PokemnRepo pokemnRepo;

    @Autowired
    public ReviewServiceImpl(ReviewRepo reviewRepo,PokemnRepo pokemnRepo)
    {
        this.reviewRepo=reviewRepo;
        this.pokemnRepo=pokemnRepo;
    }
    @Override
    public ReviewDTO createReview(int pokId, ReviewDTO reviewDTO) {
        Review review=mapToEntity(reviewDTO);
        Pokemon pokemon=pokemnRepo.findById(pokId).orElseThrow(()->new PokemonNotFound("mot found"));
        review.setPokemon(pokemon);
        Review newReview=reviewRepo.save(review);
        return mapToDto(newReview);
    }

    @Override
    public List<ReviewDTO> getReviewByPokId(int id) {
        List<Review> reviews=reviewRepo.findByPokemonId(id);
        return reviews.stream().map(review -> mapToDto(review)).collect(Collectors.toList());
    }

    @Override
    public ReviewDTO getReviewById(int reviewId, int pokId) {
        Pokemon pokemon=pokemnRepo.findById(pokId).orElseThrow(()-> new PokemonNotFound("mot found"));

        Review review=reviewRepo.findById(reviewId).orElseThrow(()-> new ReviewNotFoundException("review not found"));
        if(review.getPokemon().getId()!=pokemon.getId())
        {
            throw new ReviewNotFoundException("review not found");
        }
        return mapToDto(review);


    }

    @Override
    public ReviewDTO updateReview(int pokId, int reviewId, ReviewDTO reviewDTO) {
        Pokemon pokemon=pokemnRepo.findById(pokId).orElseThrow(()->new PokemonNotFound("id not found"));
        Review review=reviewRepo.findById(reviewId).orElseThrow(()-> new ReviewNotFoundException("not found review"));
        if(review.getPokemon().getId()!=pokemon.getId())
        {
            throw  new ReviewNotFoundException("review not matched");
        }

        review.setTitle(reviewDTO.getTitle());
        review.setContent(reviewDTO.getContent());
        review.setStars(reviewDTO.getStars());
       // review.setPokemon(pokemon);
        Review newReview=reviewRepo.save(review);
        return mapToDto(newReview);
    }


    private ReviewDTO mapToDto(Review review)
    {
        ReviewDTO reviewDTO=new ReviewDTO();
        reviewDTO.setId(review.getId());
        reviewDTO.setTitle(review.getTitle());
        reviewDTO.setContent(review.getContent());
        reviewDTO.setStars(review.getStars());
        return reviewDTO;
    }
    private Review mapToEntity(ReviewDTO reviewDTO)
    {
        Review review=new Review();
        //  pokemon.setId(pokemonDTO.getId());
        review.setId(reviewDTO.getId());
        review.setTitle(reviewDTO.getTitle());
        review.setContent(reviewDTO.getContent());
        review.setStars(reviewDTO.getStars());
        return review;


    }
}
