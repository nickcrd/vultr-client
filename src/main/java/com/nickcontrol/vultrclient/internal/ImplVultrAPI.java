package com.nickcontrol.vultrclient.internal;

import com.nickcontrol.vultrclient.VultrAPI;
import com.nickcontrol.vultrclient.managers.AccountManager;

public class ImplVultrAPI implements VultrAPI {

    public ImplVultrAPI(ConnectionManager manager)
    {

    }

    @Override
    public AccountManager getAccountManager() {
        return null;
    }

    @Override
    public ConnectionManager getConnectionManager() {
        return null;
    }
}
