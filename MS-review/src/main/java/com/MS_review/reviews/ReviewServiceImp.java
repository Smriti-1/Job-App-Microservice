package com.MS_review.reviews;

//import com.linkup.company.Companies;
//import com.linkup.company.CompanyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImp implements ReviewService {
    @Autowired
    private ReviewsRepo reviewsRepo;

//    @Autowired
//    private CompanyService companyService;

    @Override
    public Boolean deleteReview( Long id) {
//        if ((companyService.getCompanybyId(companyId) != null) && (reviewsRepo.existsById(id))) {
//            Reviews reviews = reviewsRepo.findById(id).orElse(null);
//            Companies companies = reviews.getCompany();
//            companies.getReviews().remove(reviews);
//            reviews.setCompany(null);
//            companyService.updateCompany(companyId, companies);
//            reviewsRepo.deleteById(id);
//            return true;
//        } else {
//            return false;
//        }
        Reviews review = reviewsRepo.findById(id).orElse(null);
        if (review != null) {
            reviewsRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String updateReview(Long id, Reviews data) {
        Reviews review = reviewsRepo.findById(id).orElse(null);
        if (review != null) {
            review.setTitle(data.getTitle());
            review.setDescription(data.getDescription());
            review.setRating(data.getRating());
            review.setCompanyId(data.getCompanyId());
            reviewsRepo.save(review);
            return "Updated";
        } else {
            return "Error";
        }
    }

    @Override
    public String addNewReview(Long companyId, Reviews data) {
//        Companies company = companyService.getCompanybyId(companyId);
        if (companyId != null) {
            data.setCompanyId(companyId);
            reviewsRepo.save(data);
            return "Data Saved";
        } else {
            return "Not saved no company exists";
        }
    }

    @Override
    public Reviews getReviewByid(Long id) {
        return reviewsRepo.findById(id).stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Review not found"));
    }


    @Override
    public List<Reviews> getAllReviews(Long companyId) {
        List<Reviews> reviews = reviewsRepo.findAllByCompanyId(companyId);
        return reviews;
    }
}
