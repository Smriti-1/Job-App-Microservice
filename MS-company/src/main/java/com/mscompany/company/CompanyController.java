package com.mscompany.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public List<Companies> getAllCompanies() {
        return companyService.findAllCompanies();
    }

    @GetMapping("/{id}")
    public Companies getCompanyById(@PathVariable Long id) {
        return companyService.getCompanybyId(id);
    }

    @PostMapping("/add")
    public String createNewCompany(@RequestBody Companies addNew) {
        return companyService.addNewCompany(addNew);
    }

    @PutMapping("/company/{id}")
    public String updateCompanyById(@PathVariable Long id, @RequestBody Companies update) {
        return companyService.updateCompany(id, update);
    }

    @DeleteMapping("/delete-company/{id}")
    public boolean deleteCompany(@PathVariable Long id) {
        return companyService.deleteCompany(id);
    }
}
