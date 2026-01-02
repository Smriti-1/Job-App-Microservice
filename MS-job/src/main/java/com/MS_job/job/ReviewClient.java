package com.MS_job.job;


import com.MS_job.external.Review;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "MS-REVIEW")
public interface ReviewClient {
    @GetMapping("/reviews")
    List<Review> getReviews(@RequestParam Long companyId);
}
