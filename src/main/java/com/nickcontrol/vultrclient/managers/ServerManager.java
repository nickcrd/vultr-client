package com.nickcontrol.vultrclient.managers;

import com.nickcontrol.vultrclient.entities.server.Region;
import com.nickcontrol.vultrclient.entities.server.ServerOS;
import com.nickcontrol.vultrclient.entities.server.ServerPlan;
import com.nickcontrol.vultrclient.exceptions.VultrAPIException;

public interface ServerManager
{
    String createServer(Region region, ServerPlan plan, ServerOS os) throws VultrAPIException;
}
