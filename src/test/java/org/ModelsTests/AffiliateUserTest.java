package org.ModelsTests;

import org.example.Models.AffiliateUser;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AffiliateUserTest {

    AffiliateUser affiliateUser;

    @BeforeEach
    void setUp() {
        affiliateUser = new AffiliateUser(
                1,
                "Camilo Gonzalez",
                "1023423123",
                3,
                "camilogonzalez@example.org"
        );
    }


    @Test
    void testCSVReportGeneration(){
        String report = affiliateUser.generateReportCSV();

        String reportExpected =
                "id,name,document,location,mail\n"+
                "1,Camilo Gonzalez,1023423123,3,camilogonzalez@example.org\n";
        assertEquals(reportExpected, report);
    }

    @Test
    void testDiscountGeneration(){
        Double anualPriceDiscounted = affiliateUser.generateDiscount();

        Double anualPriceExpected = 113000d;
        assertEquals(anualPriceExpected, anualPriceDiscounted);
    }
}