package org.ModelsTests;

import org.example.Models.NotAffiliateUser;
import org.example.Models.PrivateCompany;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrivateCompanyTests {
    PrivateCompany privateCompany;

    @BeforeEach
    void setUp() {
        privateCompany = new PrivateCompany(
                1,
                "1234567890",
                "John Doe",
                "New York",
                2,
                "Alice"
        );
    }

    @Test
    void testCsvReportGeneration(){
        String report = privateCompany.generateReportCSV();

        String reportExpected =
                "id,nit,name,location,idLegalRepresentative,nameLegalRepresentative\n" +
                "1,1234567890,John Doe,New York,2,Alice\n";

        assertEquals(reportExpected, report);
    }
}
