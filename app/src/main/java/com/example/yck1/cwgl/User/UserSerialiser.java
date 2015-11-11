package com.example.yck1.cwgl.User;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

/**
 * Created by yck1 on 2015/11/10.
 */
public class UserSerialiser implements JsonSerializer<User> {
    @Override
    public JsonElement serialize(final User user, Type typeOfSrc, JsonSerializationContext context) {
        final JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("email",user.getEmail());
        jsonObject.addProperty("password",user.getPassword());
        jsonObject.addProperty("money",user.getMoney());
        jsonObject.addProperty("all_sr",user.getAll_sr());
        jsonObject.addProperty("all_zc", user.getAll_zc());

        final JsonElement jsonSr = context.serialize(user.getSrs());
        jsonObject.add("sr",jsonSr);
        final JsonElement jsonZc = context.serialize(user.getZcs());
        jsonObject.add("zc",jsonZc);
        final JsonElement jsonHt = context.serialize(user.getHts());
        jsonObject.add("ht",jsonHt);
        return jsonObject;
    }
}
