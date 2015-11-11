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
public class SrDeserializer implements JsonDeserializer {
    @Override
    public Sr deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        final JsonObject jsonObject = json.getAsJsonObject();

        final Sr sr= new Sr();
        sr.setCount(jsonObject.get("count").getAsInt());
        sr.setTime(jsonObject.get("time").getAsString());
        sr.setDescription(jsonObject.get("description").getAsString());
        sr.setFs(jsonObject.get("fs").getAsString());
        sr.setFl(jsonObject.get("fl").getAsString());
        return sr;
    }
}
