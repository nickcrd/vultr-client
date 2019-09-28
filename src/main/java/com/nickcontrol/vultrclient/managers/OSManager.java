package com.nickcontrol.vultrclient.managers;

import com.nickcontrol.vultrclient.entities.server.ServerOS;
import com.nickcontrol.vultrclient.exceptions.VultrAPIException;

import java.util.List;

public interface OSManager
{
    List<ServerOS> getOSList() throws VultrAPIException;
    ServerOS getOS(int id);
}
