package com.nickcontrol.vultrclient.entities.server;

import com.nickcontrol.vultrclient.internal.entities.ImplServerOS;

public interface ServerOS
{
    /*
        Since the OS' Vultr offers, will likely change often, I'll be using the official endpoint to get a list of all OS instead of hardcoding the option like I did with regions and plans
     */

    int getId();
    String getName();
    String getArch();
    String getFamily();
    boolean isWindows();
}
