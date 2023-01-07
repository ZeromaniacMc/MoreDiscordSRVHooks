package me.zeromaniac.listener.enums;


public enum AuctionEventType {
    START("NewAuction"),
    BID("AuctionBid"),
    END_NO_BIDS("AuctionEndNoBids"),
    END_SOLD("AuctionEnd"),
    END_EXPIRED("AuctionExpired");
    

    final String value;

    private AuctionEventType(String value) {
            this.value = value;
    }

    public String getValue() {
            return value;
    }

    @Override
    public String toString() {
            return value;
    }
}
