package com.example.yck1.cwgl.User;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

/**
 * Created by yck1 on 2015/11/10.
 */
public class HtSerialiser implements JsonSerializer<Ht> {
    @Override
    public JsonElement serialize(Ht ht, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("number",ht.getNumber());
        jsonObject.addProperty("time",ht.getTime());
        jsonObject.addProperty("description",ht.getDescription());
        return jsonObject;
    }
}
