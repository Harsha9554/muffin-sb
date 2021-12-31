package com.haven.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Basic;
import javax.persistence.Embedded;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Details {
    private String shortName;
    private String fundHouse;
    private String fundName;
    private String shortCode;
    private String detailInfo;
    @JsonProperty("isin")
    private String ISIN;
    private int taxPeriod;
    @Embedded
    @Basic(optional = false)
    @JsonProperty("navData")
    private Nav nav;
    private String startDate;
    private String fundType;
    private String fundCategory;
    private String plan;
    private Double expenseRatio;
    private String expenseRatioDate;
    private String fundManager;

}
