package org.example;

import java.io.Serializable;

public class Fine implements Serializable {
    private String fineDescription;
    private int penaltyAmount;
    private String typeOfFine;

    public Fine(String fineDescription, int penaltyAmount, String typeOfFine) {
        this.fineDescription = fineDescription;
        this.penaltyAmount = penaltyAmount;
        this.typeOfFine = typeOfFine;
    }

    public String getFineDescription() {
        return fineDescription;
    }

    public void setFineDescription(String fineDescription) {
        this.fineDescription = fineDescription;
    }

    public int getPenaltyAmount() {
        return penaltyAmount;
    }

    public void setPenaltyAmount(int penaltyAmount) {
        this.penaltyAmount = penaltyAmount;
    }

    public String getTypeOfFine() {
        return typeOfFine;
    }

    public void setTypeOfFine(String typeOfFine) {
        this.typeOfFine = typeOfFine;
    }

    @Override
    public String toString() {
        return "Fine{" +
                "fineDescription='" + fineDescription + '\'' +
                ", penaltyAmount=" + penaltyAmount +
                ", typeOfFine='" + typeOfFine + '\'' +
                '}';
    }
}
