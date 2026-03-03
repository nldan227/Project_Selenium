package bb.utils;

import bb.api.dataobjects.model.Agency;

public class AgencyUtils {

    public static Agency randomValidAgency() {
        String name = StringUtils.generateFirstName();
        String agency_code = name + StringUtils.generateRandomNumeric(3);
        Agency agency = new Agency(name, agency_code);

        return agency;
    }
}
