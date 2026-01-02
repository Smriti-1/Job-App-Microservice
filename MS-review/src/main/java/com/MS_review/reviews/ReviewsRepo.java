package com.MS_review.reviews;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewsRepo extends JpaRepository<Reviews , Long> {
    List<Reviews> findAllByCompanyId(Long companyId);
//    Optional<Reviews> findByCompanyIdAndId(Long companyId, Long id);

}
