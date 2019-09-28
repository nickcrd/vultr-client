package com.nickcontrol.vultrclient.internal;

import com.nickcontrol.vultrclient.VultrAPI;
import com.nickcontrol.vultrclient.internal.managers.ImplAccountManager;
import com.nickcontrol.vultrclient.internal.managers.ImplOSManager;
import com.nickcontrol.vultrclient.internal.managers.ImplServerManager;
import com.nickcontrol.vultrclient.managers.AccountManager;
import com.nickcontrol.vultrclient.managers.OSManager;
import com.nickcontrol.vultrclient.managers.ServerManager;

public class ImplVultrAPI implements VultrAPI {

    private ConnectionManager connectionManager;
    private AccountManager accountManager;
    private OSManager osManager;
    private ServerManager serverManager;

    public ImplVultrAPI(ConnectionManager manager)
    {
        connectionManager = manager;
        accountManager = new ImplAccountManager(this);
        osManager = new ImplOSManager(this);
        serverManager = new ImplServerManager(this);
    }
    public AccountManager getAccountManager() {
        return accountManager;
    }

    public OSManager getOSManager() {
        return osManager;
    }

    public ServerManager getServerManager() {
        return serverManager;
    }


    public ConnectionManager getConnectionManager() {
        return connectionManager;
    }
}
