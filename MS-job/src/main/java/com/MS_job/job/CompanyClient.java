package com.MS_job.job;

import com.MS_job.external.Company;
import com.MS_job.external.Review;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "COMPANY-SERVICE")
public interface CompanyClient {

    @GetMapping("/companies/{id}")
    Company getCompany(@PathVariable(name = "id") Long companyId);
 }
