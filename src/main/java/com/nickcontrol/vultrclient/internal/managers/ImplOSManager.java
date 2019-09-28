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

    public ImplOSManager(VultrAPI vultrAPI)
    {
        this.vultrAPI = vultrAPI;
    }

    public List<ServerOS> getOSList() throws VultrAPIException {
        return new ArrayList<ServerOS>(vultrAPI.getConnectionManager().get(new TypeToken<HashMap<String, ImplServerOS>>(){}, "/v1/os/list").values());
    }
}
