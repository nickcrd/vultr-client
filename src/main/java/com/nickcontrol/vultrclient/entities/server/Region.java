package com.nickcontrol.vultrclient.entities.server;

import java.util.Arrays;

public enum Region
{
    /*
        Data grabbed from v1/regions/list on 9/28/2019
     */

    ATLANTA("6", "ATL"),
    CHICAGO("2", "ORD"),
    DALLAS("3", "DFW"),
    LOS_ANGELES("5", "LAX"),
    MIAMI("39", "MIA"),
    NEW_JERSEY("1", "EWR"),
    SEATTLE("4", "SEA"),
    SILICON_VALLEY("12", "SJC"),
    SINGAPORE("40", "SGP"),
    AMSTERDAM("7", "AMS"),
    TOKYO("25", "NRT"),
    LONDON("8", "LHR"),
    PARIS("24", "CDG"),
    FRANKFURT("9", "FRA"),
    TORONTO("22", "YTO"),
    SYDNEY("19", "SYD");

    private String DCID, regionCode;

    Region(String DCID, String regionCode)
    {
        this.DCID = DCID;
        this.regionCode = regionCode;
    }

    public String getDCID()
    {
        return DCID;
    }

    public String getRegionCode()
    {
        return regionCode;
    }

    public static Region fromId(String id)
    {
        return Arrays.stream(Region.values()).filter(region -> region.getDCID().equals(id)).findAny().orElse(null);
    }

}
