package com.nickcontrol.vultrclient.managers;

import com.nickcontrol.vultrclient.entities.server.*;
import com.nickcontrol.vultrclient.exceptions.VultrAPIException;

import java.util.List;

public interface ServerManager
{
    String createServer(String hostname, Region region, ServerPlan plan, ServerOS os) throws VultrAPIException;

    String createServer(String hostname, Region region, ServerPlan plan, ServerOS os, ServerOptions options) throws VultrAPIException;

    List<Server> listServers() throws VultrAPIException;
    List<Server> listServersWithTag(String tag) throws VultrAPIException;
    List<Server> listServersWithLabel(String label) throws VultrAPIException;

    Server getServerById(int subId) throws VultrAPIException;
    Server getServerByIPv4(String ip) throws VultrAPIException;


    void enablePrivateNetwork(Server server) throws VultrAPIException;
    void enablePrivateNetwork(String serverId) throws VultrAPIException;

    void disablePrivateNetwork(Server server) throws VultrAPIException;
    void disablePrivateNetwork(String serverId) throws VultrAPIException;

    void destroyServer(Server server) throws VultrAPIException;
    void destroyServer(String serverId) throws VultrAPIException;

}
