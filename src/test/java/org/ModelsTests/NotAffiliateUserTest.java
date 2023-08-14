package org.ModelsTests;

import org.example.Models.AffiliateUser;
import org.example.Models.NotAffiliateUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotAffiliateUserTest {
    NotAffiliateUser notAffiliateUser;

    @BeforeEach
    void setUp() {
        notAffiliateUser = new NotAffiliateUser(
                1,
                "Camilo Gonzalez",
                "1023423123",
                3,
                "camilogonzalez@example.org"
        );
    }

    @Test
    void calculateAnnualPayment() {

    }

    @Test
    void testReportGeneration(){
        String report = notAffiliateUser.generateReportCSV();

        String reportExpected =
                "id,name,document,location,mail\n"+
                "1,Camilo Gonzalez,1023423123,3,camilogonzalez@example.org\n";
        assertEquals(reportExpected, report);
    }
}