package com.mscompany.company;

//import com.linkup.job.Job;
//import com.linkup.reviews.Reviews;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Companies {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String companyName;
    private String companyDesc;

//    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//    @JsonIgnoreProperties("company")
//    private List<Job> jobs;
//
//    @OneToMany(mappedBy = "company")
//    @JsonIgnore
//    private List<Reviews> reviews;

}
