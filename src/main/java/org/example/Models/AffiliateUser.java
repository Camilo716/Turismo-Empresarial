package org.example.Models;

import org.example.Models.AbstractEntities.User;
import org.example.Models.EntitiesOperations.IDiscountable;
import org.example.Models.EntitiesOperations.IReportable;

public class AffiliateUser extends User implements IReportable, IDiscountable {

    public AffiliateUser(Integer id, String name, String document, Integer location, String mail) {
        super(id, name, document, location, mail);
    }

    @Override
    public Double calculateAnnualPayment() {
        return null;
    }

    @Override
    public String generateReportCSV() {
        StringBuilder csvBuilder = new StringBuilder();

        csvBuilder.append("id,name,document,location,mail\n");
        csvBuilder.append(formatUserCSV(this));

        return csvBuilder.toString();
    }

    private static String formatUserCSV(AffiliateUser user) {
        return String.format(
                "%d,%s,%s,%d,%s\n",
                user.getId(),
                user.getName(),
                user.getDocument(),
                user.getLocationNum(),
                user.getMail()
            );
    }

    @Override
    public Double generateDiscount() {
        return anualCost - monthlyCost * 0.2;
    }
}
