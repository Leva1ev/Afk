package LevaLev.afk.Utils;

import LevaLev.afk.Afk;
import LevaLev.afk.Models.ShardData;
import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

public class ShardDataStorageUtil {

    private static ArrayList<ShardData> shardData = new ArrayList<>();

    public static ShardData createShardData(UUID uuid, Integer integer) throws IOException {

        ShardData data = new ShardData(uuid, integer);
        shardData.add(data);
        saveShardData();

        return data;
    }

    public static Integer getShardAmount(UUID uuid){
        for(ShardData data : shardData){
            if (data.getUuid().equals(uuid)){
                return data.getShardAmount();
            }
        }
        return null;
    }

    public static Boolean hasBeenRegistered(UUID uuid) {
        for(ShardData data : shardData){
            if (data.getUuid().equals(uuid)){
                return true;
            }
        }
        return false;
    }

    public static ShardData updateShardData(UUID uuid, Integer integer) throws IOException {
        for(ShardData data : shardData){
            if (data.getUuid().equals(uuid)){
                data.setShardAmount(integer);
                saveShardData();
                break;
            }
        }
        return null;
    }

    public static void saveShardData() throws IOException {
        Gson gson = new Gson();
        File file = new File(Afk.getPlugin().getDataFolder().getAbsolutePath() + "/shardData.json");
        file.getParentFile().mkdirs();
        file.createNewFile();
        Writer writer = new FileWriter(file, false);
        gson.toJson(shardData, writer);
        writer.flush();
        writer.close();
        System.out.println("AFK | Shard Data saved.");

    }

    public static void loadNotes() throws IOException {

        Gson gson = new Gson();
        File file = new File(Afk.getPlugin().getDataFolder().getAbsolutePath() + "/shardData.json");
        if (file.exists()) {
            Reader reader = new FileReader(file);
            ShardData[] s = gson.fromJson(reader, ShardData[].class);
            shardData = new ArrayList<>(Arrays.asList(s));
            System.out.println("Shards data loaded.");
        }

    }

}
