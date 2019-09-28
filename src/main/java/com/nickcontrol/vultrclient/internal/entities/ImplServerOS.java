package com.nickcontrol.vultrclient.internal.entities;

import com.nickcontrol.vultrclient.entities.server.ServerOS;

public class ImplServerOS implements ServerOS
{
    private String OSID, name, arch, family;
    private boolean windows;

    public int getId() {
        return Integer.parseInt(OSID);
    }

    public String getName() {
        return name;
    }

    public String getArch() {
        return arch;
    }

    public String getFamily() {
        return family;
    }

    public boolean isWindows() {
        return windows;
    }
}
