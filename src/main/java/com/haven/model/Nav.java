package com.haven.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@AllArgsConstructor
@Embeddable
@Data
public class Nav {
    @Column(nullable = false, columnDefinition = "Decimal(10,3) default '0.000'")
    @JsonProperty("nav")
    private Double navValue = Double.valueOf(0);
    @JsonProperty("date")
    @Column(nullable = false)
    private String navDate;

    public Nav() {
        this.navValue = Double.parseDouble("0") ;
        this.navDate = "22-01-2021";
    }
}

