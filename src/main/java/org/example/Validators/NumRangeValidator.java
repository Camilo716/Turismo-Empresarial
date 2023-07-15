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
        boolean isHigherThanMaxNum = num > this.maxNum;
        boolean isLowerThanMinNum = num < this.minNum;

        if (isHigherThanMaxNum)
            throw new Exception(String.format("Number can't be higher than %f", this.maxNum));
        if (isLowerThanMinNum)
            throw new Exception(String.format("Number can't be lower than %f", this.minNum));

        return true;
    }
}
