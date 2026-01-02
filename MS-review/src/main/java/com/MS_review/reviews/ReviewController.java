package com.MS_review.reviews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/companies/{companyId}")
@RequestMapping("reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;


    @GetMapping
    public List<Reviews> getAllReviews(@RequestParam Long companyId) {
        return reviewService.getAllReviews(companyId);
    }

    @GetMapping("/{id}")
    public Reviews getReviewById(@PathVariable Long id) {
        return reviewService.getReviewByid(id);
    }

    @PostMapping("/add-review")
    public String addReview(@RequestParam Long companyId, @RequestBody Reviews data) {
        return reviewService.addNewReview(companyId, data);
    }

    @PutMapping("/update-review/{id}")
    public String updateReview(@PathVariable Long id, @RequestBody Reviews data) {
        return reviewService.updateReview(id, data);
    }

    @DeleteMapping("/delete-review/{Id}")
    public Boolean deleteReview(@PathVariable Long Id) {
        return reviewService.deleteReview(Id);
    }

}
