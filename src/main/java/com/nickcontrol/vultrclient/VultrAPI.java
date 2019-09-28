package com.nickcontrol.vultrclient;

import com.nickcontrol.vultrclient.managers.AccountManager;
import com.nickcontrol.vultrclient.internal.ConnectionManager;

public interface VultrAPI
{
    AccountManager getAccountManager();

    ConnectionManager getConnectionManager();
}
