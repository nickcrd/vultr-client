package com.nickcontrol.vultrclient.managers;

import com.nickcontrol.vultrclient.entities.server.*;
import com.nickcontrol.vultrclient.exceptions.VultrAPIException;
import sun.security.provider.certpath.ssl.SSLServerCertStore;

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

}
