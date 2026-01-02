package com.mscompany.company;

import java.util.List;

public interface CompanyService {
    List<Companies> findAllCompanies();

    Companies getCompanybyId(Long id);

    String addNewCompany(Companies addNew);

    String updateCompany(Long id, Companies update);

    boolean deleteCompany(Long id);
}
