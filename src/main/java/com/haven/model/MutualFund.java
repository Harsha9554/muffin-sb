package com.haven.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class MutualFund {
    private String name;
    @Id
    private String code;
    @Embedded
    private Returns returns;
    private Double volatility;
    private String categoryMentioned;
    private String category;
    private String subCategory;
    @Embedded
    private Details details;
}
