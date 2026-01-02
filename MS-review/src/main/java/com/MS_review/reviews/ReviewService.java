package com.MS_review.reviews;

import java.util.List;

public interface ReviewService {

    Boolean deleteReview(Long id);

    String updateReview(Long id, Reviews data);

    String addNewReview(Long companyId, Reviews data);

    Reviews getReviewByid(Long id);

    List<Reviews> getAllReviews(Long companyId);
}
