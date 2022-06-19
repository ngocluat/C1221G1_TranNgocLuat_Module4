package com.furama.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Positon {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long positionId;
    private String positionName;

    public Positon() {
    }

    public Positon(Long positionId, String positionName) {
        this.positionId = positionId;
        this.positionName = positionName;
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
}
