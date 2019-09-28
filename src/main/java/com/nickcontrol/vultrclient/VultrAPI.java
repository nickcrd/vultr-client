package com.nickcontrol.vultrclient;

import com.nickcontrol.vultrclient.managers.AccountManager;
import com.nickcontrol.vultrclient.internal.ConnectionManager;
import com.nickcontrol.vultrclient.managers.OSManager;
import com.nickcontrol.vultrclient.managers.ServerManager;

public interface VultrAPI
{
    AccountManager getAccountManager();
    OSManager getOSManager();
    ServerManager getServerManager();

    ConnectionManager getConnectionManager();
}
