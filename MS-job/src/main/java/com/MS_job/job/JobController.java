package com.MS_job.job;

import com.MS_job.dto.JobDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping
    public List<JobDTO> getAllJobsListing() {
        return jobService.getAllListing();
    }

    @GetMapping("/job/{id}")
    public JobDTO getJobById(@PathVariable Long id) {
        return jobService.getListingById(id);
    }

    @PostMapping("/create")
    public String addNewJobListing(@RequestBody Job addNew) {
        return jobService.addNewListing(addNew);
    }

    @PutMapping("/job/{id}")
    public String updateJobListing(@PathVariable Long id, @RequestBody Job update) {
        return jobService.updateListing(id, update);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteJobById(@PathVariable Long id) {
        return jobService.deleteJobById(id);
    }
}
