package io.coti.financialserver.data;

import java.util.EnumSet;

public enum ReservedAddress {
    GENESIS_ONE(0),
    GENESIS_TWO(1),
    TOKEN_SELL(2),
    INCENTIVES(3),
    TEAM(4),
    ADVISORS(5),
    PRIVATE_SALE(6),
    PRE_SALE(7),
    EQUITY_INVESTORS(8),
    ROLLING_RESERVE_POOL(9),
    NETWORK_FEE_POOL(10);

    private final long index;

    ReservedAddress(long index) {
        this.index = index;
    }

    public long getIndex() {
        return index;
    }

    public boolean isGenesisAddress() {
        return index == 0 || index == 1;
    }

    public boolean isInitialFundDistribution() {
        return index > 1 && index < 6;
    }

    public static EnumSet<ReservedAddress> getInitialFundDistributionAddresses() {
        EnumSet<ReservedAddress> initialFundDistributionAddresses = EnumSet.noneOf(ReservedAddress.class);
        for (ReservedAddress reservedAddress : values()) {
            if (reservedAddress.isInitialFundDistribution()) {
                initialFundDistributionAddresses.add(reservedAddress);
            }
        }
        return initialFundDistributionAddresses;
    }
}
