package com.MS_job.job;

import com.MS_job.dto.JobDTO;
import com.MS_job.external.Company;
import com.MS_job.external.Review;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Fallback;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImp implements JobService {

    @Autowired
    JobRepo jobRepo;

    @Autowired
    CompanyClient companyClient;

    @Autowired
    ReviewClient reviewClient;

    @Override
    @CircuitBreaker(name ="companyBreaker" , fallbackMethod = "fixCircuitBreak")
    public List<JobDTO> getAllListing() {
        List<Job> jobs = jobRepo.findAll();
        List<JobDTO> jobWithCompanyDTOs = new ArrayList<>();

        for (Job job : jobs) {
            JobDTO jobWithCompanyDTO = new JobDTO();
            jobWithCompanyDTO.setJob(job);
            Company company = companyClient.getCompany(job.getCompanyId());
            jobWithCompanyDTO.setCompany(company);

            List<Review> reviews = reviewClient.getReviews(company.getId());
            jobWithCompanyDTO.setReview(reviews);
            jobWithCompanyDTOs.add(jobWithCompanyDTO);
        }
        return jobWithCompanyDTOs;
    }

    public List<String> fixCircuitBreak(Exception e){
        List<String> list = new ArrayList<>();
        list.add("dummy");
        return list;
    }

    @Override
    public JobDTO getListingById(Long id) {
        Job job = jobRepo.findById(id).orElse(null);
        List<JobDTO> jobWithCompanyDTOs = new ArrayList<>();

        JobDTO jobWithCompanyDTO = new JobDTO();
        jobWithCompanyDTO.setJob(job);

        Company company = companyClient.getCompany(job.getCompanyId());
        jobWithCompanyDTO.setCompany(company);

        List<Review> reviews = reviewClient.getReviews(company.getId());
        jobWithCompanyDTO.setReview(reviews);
        jobWithCompanyDTOs.add(jobWithCompanyDTO);


        return jobWithCompanyDTO;
    }

    @Override
    public String addNewListing(Job addNew) {
        jobRepo.save(addNew);
        return "Added Successfully";
    }

    @Override
    public String updateListing(Long id, Job update) {
        Optional<Job> jobOptional = jobRepo.findById(id);
        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();
            job.setTitle(update.getTitle());
            job.setDescriprition(update.getDescriprition());
            job.setMinSalary(update.getMinSalary());
            job.setMaxSalary(update.getMaxSalary());
            job.setLocation(update.getLocation());
            job.setCompanyId(update.getCompanyId());
            jobRepo.save(job);

            return "Updated Successfully";
        } else {
            return "No Listing Found with Such id : " + id;
        }
    }

    @Override
    public String deleteJobById(Long id) {
        Optional<Job> jobOptional = jobRepo.findById(id);
        if (jobOptional.isPresent()) {
            jobRepo.deleteById(id);
            return "deleted";
        } else {
            return "No Listing Found with Such id : " + id;
        }
    }
}
