package org.ModelsTests;

import org.example.Models.AffiliateUser;
import org.example.Models.CulturalGrouping;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CulturalGroupingTest {

    CulturalGrouping culturalGrouping;

    @BeforeEach
    void setUp() {
        culturalGrouping = new CulturalGrouping(
                1,
                "123123123",
                "Company S.A.S",
                "New York",
                "Description"
        );
    }

    @Test
    void testCsvReportGeneration(){
        String report = culturalGrouping.generateReportCSV();

        String reportExpected =
                "id,nit,name,location,description\n"+
                "1,123123123,Company S.A.S,New York,Description\n";
        assertEquals(reportExpected, report);
    }
}
