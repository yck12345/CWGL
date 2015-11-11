package com.example.yck1.cwgl.User;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

/**
 * Created by yck1 on 2015/11/10.
 */
public class ZcSerialiser implements JsonSerializer<Zc> {
    @Override
    public JsonElement serialize(Zc zc, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject= new JsonObject();
        jsonObject.addProperty("count",zc.getCount());
        jsonObject.addProperty("time",zc.getTime());
        jsonObject.addProperty("description",zc.getDescription());
        jsonObject.addProperty("fs",zc.getFs());
        jsonObject.addProperty("fl",zc.getFl());
        return jsonObject;
    }
}
