package com.nickcontrol.vultrclient.internal.managers;

import com.nickcontrol.vultrclient.VultrAPI;
import com.nickcontrol.vultrclient.entities.account.AccountInfo;
import com.nickcontrol.vultrclient.exceptions.VultrAPIException;
import com.nickcontrol.vultrclient.internal.entities.ImplAccountInfo;
import com.nickcontrol.vultrclient.managers.AccountManager;

public class ImplAccountManager implements AccountManager
{
    private VultrAPI vultrAPI;

    public ImplAccountManager(VultrAPI vultrAPI)
    {
        this.vultrAPI = vultrAPI;
    }

    public AccountInfo getInfo() throws VultrAPIException {
        return vultrAPI.getConnectionManager().get(ImplAccountInfo.class, "/v1/account/info");
    }
}
