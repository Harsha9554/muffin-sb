package com.haven.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TrackingFunds {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String fundCode;
    @Column
    private Long userId;

    public TrackingFunds(Long userId, String fundCode) {
        this.userId = userId;
        this.fundCode = fundCode;
    }
}
