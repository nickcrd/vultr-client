package com.nickcontrol.vultrclient.managers;

import com.nickcontrol.vultrclient.entities.account.AccountInfo;
import com.nickcontrol.vultrclient.exceptions.VultrAPIException;

public interface AccountManager
{
    AccountInfo getInfo() throws VultrAPIException;
}
