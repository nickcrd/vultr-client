package com.nickcontrol.vultrclient.entities.account;

import java.util.Date;

public interface AccountInfo
{
    double getBalance();
    double getPendingCharges();
    Date getLastPaymentDate();
    double getLastPaymentAmount();

}
