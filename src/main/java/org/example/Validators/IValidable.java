package org.example.Validators;

public interface IValidable<T> {
    Boolean validate(T input) throws Exception;
}
