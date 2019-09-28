package com.nickcontrol.vultrclient.internal.entities;

import com.nickcontrol.vultrclient.entities.account.AccountInfo;
import com.nickcontrol.vultrclient.utils.Util;

import java.text.ParseException;
import java.util.Date;

public class ImplAccountInfo implements AccountInfo
{
    private String balance;
    private String pending_charges;
    private String last_payment_date;
    private String last_payment_amount;

    public double getBalance() {
        return Double.parseDouble(balance);
    }

    public double getPendingCharges() {
        return Double.parseDouble(pending_charges);
    }

    public Date getLastPaymentDate() {
        try {
            return Util.dateFormat.parse(last_payment_date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public double getLastPaymentAmount() {
        return Double.parseDouble(last_payment_amount);
    }
}
