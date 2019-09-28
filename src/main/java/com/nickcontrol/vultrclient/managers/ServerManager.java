package com.nickcontrol.vultrclient.managers;

import com.nickcontrol.vultrclient.exceptions.VultrAPIException;

public interface ServerManager
{
    String createServer() throws VultrAPIException;

}
