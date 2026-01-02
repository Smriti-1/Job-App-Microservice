package com.mscompany.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImp implements CompanyService{

    @Autowired
    CompanyRepo companyRepo;

    @Override
    public List<Companies> findAllCompanies() {
        return companyRepo.findAll();
    }

    @Override
    public Companies getCompanybyId(Long id) {
        return companyRepo.findById(id).orElse(null);
    }

    @Override
    public String addNewCompany(Companies addNew) {

        companyRepo.save(addNew);
        return "Added Successfully";
    }

    @Override
    public String updateCompany(Long id, Companies update) {
        Optional<Companies> companies = companyRepo.findById(id);
        if(companies.isPresent()){
            Companies comp = companies.get();
            comp.setCompanyName(update.getCompanyName());
            comp.setCompanyDesc(update.getCompanyDesc());
//            comp.setJobs(update.getJobs());
            companyRepo.save(comp);

            return  "Updated Successfully";
        }else {
            return "No Listing Found with Such id : " + id;
        }
    }

    @Override
    public boolean deleteCompany(Long id) {
        Optional<Companies> company = companyRepo.findById(id);
        if(company.isPresent()){
            companyRepo.delete(company.get());
            return true;
        }else{
            return false;
        }
    }
}
