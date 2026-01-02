package com.MS_review.reviews;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.linkup.company.Companies;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Reviews {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String description;
    private double rating;

    private Long companyId;

//    @JsonIgnore
//    @ManyToOne
//    private Companies company;
}
