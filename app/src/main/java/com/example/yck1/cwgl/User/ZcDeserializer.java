package com.example.yck1.cwgl.User;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by yck1 on 2015/11/10.
 */
public class ZcDeserializer implements JsonDeserializer {
    @Override
    public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        final JsonObject jsonObject = json.getAsJsonObject();

        final Zc zc= new Zc();
        zc.setCount(jsonObject.get("count").getAsInt());
        zc.setTime(jsonObject.get("time").getAsString());
        zc.setDescription(jsonObject.get("description").getAsString());
        zc.setFs(jsonObject.get("fs").getAsString());
        zc.setFl(jsonObject.get("fl").getAsString());
        return zc;
    }
}
