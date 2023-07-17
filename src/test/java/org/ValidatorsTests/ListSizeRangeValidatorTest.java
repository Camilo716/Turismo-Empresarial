package org.ValidatorsTests;

import org.example.Validators.ListSizeRangeValidator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ListSizeRangeValidatorTest {
    @Test
    public void testMaxSize4Validation() throws Exception {
        ListSizeRangeValidator<Integer> validator = new ListSizeRangeValidator<>(0, 4);
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

        assertThrows(Exception.class, () -> {
            validator.validate(list);
        });
    }
}
