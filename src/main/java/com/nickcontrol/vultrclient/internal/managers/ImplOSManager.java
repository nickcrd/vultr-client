package com.nickcontrol.vultrclient.internal.managers;

import com.google.gson.reflect.TypeToken;
import com.nickcontrol.vultrclient.VultrAPI;
import com.nickcontrol.vultrclient.entities.server.ServerOS;
import com.nickcontrol.vultrclient.exceptions.VultrAPIException;
import com.nickcontrol.vultrclient.internal.entities.ImplServerOS;
import com.nickcontrol.vultrclient.managers.OSManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ImplOSManager implements OSManager {

    private VultrAPI vultrAPI;

    private HashMap<String, ImplServerOS> osCache = new HashMap<>();

    public ImplOSManager(VultrAPI vultrAPI)
    {
        this.vultrAPI = vultrAPI;
    }

    public List<ServerOS> getOSList() throws VultrAPIException {
        osCache = vultrAPI.getConnectionManager().get(new TypeToken<HashMap<String, ImplServerOS>>(){}, "/v1/os/list");
        return new ArrayList<ServerOS>(osCache.values());
    }

    public ServerOS getOS(int id)
    {
        return osCache.get(String.valueOf(id));
    }
}
