package com.nickcontrol.vultrclient.entities.server;

import java.util.Date;

public interface Server
{
    /*
        Only contains relevant information for NICKCONTROL Studios related purposes. For example all IPv6 related information are omitted
     */

    String getId();
    ServerOS getOS();
    ServerPlan getPlan();

    int getCpu();
    int getRam();

    String getDisk();

    String getMainIp();
    String getInternalIp();

    Region getRegion();

    String getDefaultPassword();

    Date getDateCreated();

    double getPendingCharges();

    ServerStatus getServerStatus();
    PowerState getPowerState();
    ServerState getServerState();

}
