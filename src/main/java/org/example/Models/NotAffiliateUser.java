package org.example.Models;

import org.example.Models.AbstractEntities.User;
import org.example.Models.EntitiesOperations.IReportable;

public class NotAffiliateUser extends User implements IReportable {
    public NotAffiliateUser(Integer id, String name, String document, Integer location, String mail) {
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

    private static String formatUserCSV(NotAffiliateUser user) {
        return String.format(
                "%d,%s,%s,%d,%s\n",
                user.getId(),
                user.getName(),
                user.getDocument(),
                user.getLocationNum(),
                user.getMail()
        );
    }
}
