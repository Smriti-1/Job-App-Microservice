package com.MS_job.job;

//import com.linkup.company.Companies;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "jobs")
@Data
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String descriprition;
    private String minSalary;
    private String maxSalary;
    private String location;
    private Long companyId;
//
//    @ManyToOne
//    @JoinColumn(name = "company_id")
//    @JsonIgnoreProperties("jobs")
//    private Companies company;

}
