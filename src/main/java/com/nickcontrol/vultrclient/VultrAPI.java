package com.nickcontrol.vultrclient;

import com.nickcontrol.vultrclient.managers.AccountManager;
import com.nickcontrol.vultrclient.internal.ConnectionManager;
import com.nickcontrol.vultrclient.managers.OSManager;

public interface VultrAPI
{
    AccountManager getAccountManager();
    OSManager getOSManager();

    ConnectionManager getConnectionManager();
}
