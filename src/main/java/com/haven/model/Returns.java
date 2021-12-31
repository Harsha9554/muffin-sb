package com.haven.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class Returns {
    @JsonProperty("1")
    private Double oneY;
    @JsonProperty("3")
    private Double threeY;
    @JsonProperty("5")
    private Double fiveY;
    private Double inception;
    private String date;
}
