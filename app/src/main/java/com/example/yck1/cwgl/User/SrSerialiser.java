package com.example.yck1.cwgl.User;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

/**
 * Created by yck1 on 2015/11/10.
 */
public class SrSerialiser implements JsonSerializer<Sr> {
    @Override
    public JsonElement serialize(Sr sr, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject= new JsonObject();
        jsonObject.addProperty("count",sr.getCount());
        jsonObject.addProperty("time",sr.getTime());
        jsonObject.addProperty("description",sr.getDescription());
        jsonObject.addProperty("fs",sr.getFs());
        jsonObject.addProperty("fl",sr.getFl());
        return jsonObject;
    }
}
