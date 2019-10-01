package com.nickcontrol.vultrclient.internal.entities;

import com.nickcontrol.vultrclient.VultrAPI;
import com.nickcontrol.vultrclient.entities.server.*;
import com.nickcontrol.vultrclient.utils.Util;

import java.text.ParseException;
import java.util.Date;

public class ImplServer implements Server
{
    public VultrAPI _vultrApi;

    private String SUBID;

    private String OSID; // Os name, do lookup via API
    private ServerOS osCached;

    private String VPSPLANID;
    private String DCID;

    private String vcpu_count;
    private String ram;

    private String disk;

    private String main_ip;
    private String internal_ip;

    private String default_password;
    private String date_created;

    private String pending_charges;

    private String status;
    private String power_status;
    private String server_state;

    @Override
    public String getId() {
        return SUBID;
    }

    @Override
    public ServerOS getOS() {
        if (osCached == null)
            osCached = _vultrApi.getOSManager().getOS(Integer.parseInt(OSID));

        return osCached;
    }

    @Override
    public ServerPlan getPlan() {
        return ServerPlan.fromId(Integer.parseInt(VPSPLANID));
    }

    @Override
    public int getCpu() {
        return Integer.parseInt(vcpu_count);
    }

    @Override
    public int getRam() {
        return Integer.parseInt(ram.replace(" MB", ""));
    }

    @Override
    public String getDisk() {
        return disk;
    }

    @Override
    public String getMainIp() {
        return main_ip;
    }

    @Override
    public String getInternalIp() {
        return internal_ip;
    }

    @Override
    public Region getRegion() {
        return Region.fromId(DCID);
    }

    @Override
    public String getDefaultPassword() {
        return default_password;
    }

    @Override
    public Date getDateCreated() {
        try {
            return Util.dateFormat.parse(date_created);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public double getPendingCharges() {
        return Double.parseDouble(pending_charges);
    }

    @Override
    public ServerStatus getServerStatus() {
        return ServerStatus.valueOf(status);
    }

    @Override
    public PowerState getPowerState() {
        return PowerState.valueOf(power_status);
    }

    @Override
    public ServerState getServerState() {
        return ServerState.valueOf(server_state);
    }
}
