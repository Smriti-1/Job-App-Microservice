package com.MS_job.dto;

import com.MS_job.external.Company;
import com.MS_job.external.Review;
import com.MS_job.job.Job;
import lombok.Data;

import java.util.List;

@Data
public class JobDTO {
    private Job job;
    private Company company;
    private List<Review> review;
}
