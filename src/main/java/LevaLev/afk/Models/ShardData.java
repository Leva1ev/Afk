package LevaLev.afk.Models;

import java.util.UUID;

public class ShardData {

    private UUID uuid;
    private Integer shardAmount;

    public ShardData(UUID uuid, Integer shardAmount) {
        this.uuid = uuid;
        this.shardAmount = shardAmount;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Integer getShardAmount() {
        return shardAmount;
    }

    public void setShardAmount(Integer shardAmount) {
        this.shardAmount = shardAmount;
    }
}
