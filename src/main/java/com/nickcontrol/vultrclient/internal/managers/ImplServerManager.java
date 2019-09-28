package com.nickcontrol.vultrclient.internal.managers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.nickcontrol.vultrclient.VultrAPI;
import com.nickcontrol.vultrclient.entities.server.Region;
import com.nickcontrol.vultrclient.entities.server.ServerOS;
import com.nickcontrol.vultrclient.entities.server.ServerOptions;
import com.nickcontrol.vultrclient.entities.server.ServerPlan;
import com.nickcontrol.vultrclient.exceptions.VultrAPIException;
import com.nickcontrol.vultrclient.managers.ServerManager;

import java.util.HashMap;

public class ImplServerManager implements ServerManager {
    private VultrAPI vultrAPI;

    public ImplServerManager(VultrAPI vultrAPI)
    {
        this.vultrAPI = vultrAPI;
    }

    public String createServer(String hostname, Region region, ServerPlan plan, ServerOS os) throws VultrAPIException {
        return createServer(hostname, region, plan, os, null);
    }


    public String createServer(String hostname, Region region, ServerPlan plan, ServerOS os, ServerOptions options) throws VultrAPIException {
        HashMap<String, Object> data = new HashMap<>();
        data.put("DCID", region.getDCID());
        data.put("VPSPLANID", String.valueOf(plan.getPlanId()));
        data.put("OSID", String.valueOf(os.getId()));
        data.put("hostname", hostname);

        // TODO add support for server options

        String returnedData = vultrAPI.getConnectionManager().post("/v1/server/create", data);

        JsonObject obj = new Gson().fromJson(returnedData, JsonObject.class);
        return obj.get("SUBID").getAsString();
    }
}
