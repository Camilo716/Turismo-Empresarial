package org.example.Validators;

public class NumRangeValidator implements IValidable<Double>{
    Double minNum;
    Double maxNum;

    public NumRangeValidator(Double minNum, Double maxNum) {
        this.minNum = minNum;
        this.maxNum = maxNum;
    }

    @Override
    public Boolean validate(Double num) throws Exception {
        boolean isHigherThan4 = num > this.maxNum;
        boolean isLowerThan1 = num < this.minNum;

        if (isHigherThan4){
            throw new Exception(String.format("Number can't be higher than %f", this.maxNum));
        } else if (isLowerThan1) {
            throw new Exception(String.format("Number can't be lower than %f", this.minNum));
        }
        return true;
    }
}
