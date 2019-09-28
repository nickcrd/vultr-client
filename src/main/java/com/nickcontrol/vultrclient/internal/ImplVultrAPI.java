package com.nickcontrol.vultrclient.internal;

import com.nickcontrol.vultrclient.VultrAPI;
import com.nickcontrol.vultrclient.internal.managers.ImplAccountManager;
import com.nickcontrol.vultrclient.managers.AccountManager;

public class ImplVultrAPI implements VultrAPI {

    private ConnectionManager connectionManager;
    private AccountManager accountManager;

    public ImplVultrAPI(ConnectionManager manager)
    {
        connectionManager = manager;
        accountManager = new ImplAccountManager(this);
    }
    public AccountManager getAccountManager() {
        return accountManager;
    }

    public ConnectionManager getConnectionManager() {
        return connectionManager;
    }
}
