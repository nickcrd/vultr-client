package com.nickcontrol.vultrclient.entities.server;

public enum ServerPlan
{
     /*
        Data grabbed from v1/plans/list on 9/28/2019
     */

    // Cloud Compute
    CC_1vCore_1GB(201),
    CC_1vCore_2GB(202),
    CC_2vCore_4GB(203),
    CC_4vCore_8GB(204),
    CC_6vCore_16GB(205),
    CC_8vCore_32GB(206),
    CC_16vCore_64GB(207),
    CC_16vCore_96GB(208),

    // Dedicated
    DEDI_2Core_8GB(115),
    DEDI_4Core_16GB(116),
    DEDI_6Core_24GB(117),
    DEDI_8Core_32GB(118),

    // High Frequency Cloud Compute
    HIGH_FREQ_1vCore_1GB(400),
    HIGH_FREQ_2vCore_2GB(401),
    HIGH_FREQ_2vCore_4GB(402),
    HIGH_FREQ_3vCore_8GB(403),
    HIGH_FREQ_4vCore_16GB(404),
    HIGH_FREQ_8vCore_32GB(405),
    HIGH_FREQ_12vCore_48GB(406);

    private int planId;
    ServerPlan(int planId) {
        this.planId = planId;
    }

    public int getPlanId()
    {
        return planId;
    }
}
