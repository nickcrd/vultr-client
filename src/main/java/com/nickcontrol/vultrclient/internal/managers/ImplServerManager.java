package com.nickcontrol.vultrclient.internal.managers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.nickcontrol.vultrclient.VultrAPI;
import com.nickcontrol.vultrclient.entities.server.*;
import com.nickcontrol.vultrclient.exceptions.VultrAPIException;
import com.nickcontrol.vultrclient.internal.entities.ImplServer;
import com.nickcontrol.vultrclient.managers.ServerManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<Server> listServers() throws VultrAPIException {
        TypeToken<Map<String, ImplServer>> t = new TypeToken<Map<String, ImplServer>>(){};

        Map<String, ImplServer> servers = vultrAPI.getConnectionManager().get(t, "/v1/server/list");
        servers.values().forEach(implServer -> implServer._vultrApi = vultrAPI);

        return new ArrayList<>(servers.values());
    }

    @Override
    public List<Server> listServersWithTag(String tag) throws VultrAPIException {
        TypeToken<Map<String, ImplServer>> t = new TypeToken<Map<String, ImplServer>>(){};

        Map<String, ImplServer> servers = vultrAPI.getConnectionManager().get(t, "/v1/server/list?tag=" + tag);
        servers.values().forEach(implServer -> implServer._vultrApi = vultrAPI);

        return new ArrayList<>(servers.values());
    }

    @Override
    public List<Server> listServersWithLabel(String label) throws VultrAPIException {
        TypeToken<Map<String, ImplServer>> t = new TypeToken<Map<String, ImplServer>>(){};

        Map<String, ImplServer> servers = vultrAPI.getConnectionManager().get(t, "/v1/server/list?label=" + label);
        servers.values().forEach(implServer -> implServer._vultrApi = vultrAPI);

        return new ArrayList<>(servers.values());
    }

    @Override
    public Server getServerById(int subId) throws VultrAPIException {
        ImplServer server =  vultrAPI.getConnectionManager().get(ImplServer.class, "/v1/server/list?SUBID=" + subId);
        server._vultrApi = vultrAPI;
        return server;
    }

    @Override
    public Server getServerByIPv4(String ip) throws VultrAPIException {
        ImplServer server = vultrAPI.getConnectionManager().get(ImplServer.class, "/v1/server/list?main_ip=" + ip);
        server._vultrApi = vultrAPI;
        return server;
    }
}
