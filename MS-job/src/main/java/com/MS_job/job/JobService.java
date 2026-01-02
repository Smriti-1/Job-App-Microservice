package com.MS_job.job;

import com.MS_job.dto.JobDTO;

import java.util.List;

public interface JobService {

    public List<JobDTO> getAllListing() ;
    JobDTO getListingById(Long id);
    String addNewListing(Job addNew);
    String updateListing(Long id, Job update);
    String deleteJobById(Long id);
}
