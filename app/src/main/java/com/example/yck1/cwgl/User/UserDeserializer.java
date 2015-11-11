package com.example.yck1.cwgl.User;

import com.example.yck1.cwgl.File.FileIO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.io.Reader;
import java.lang.reflect.Type;

/**
 * Created by yck1 on 2015/11/10.
 */
public class UserDeserializer implements JsonDeserializer {
    @Override
    public User deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        final JsonObject jsonObject = json.getAsJsonObject();

        final String email=jsonObject.get("email").getAsString();
        final String password = jsonObject.get("password").getAsString();
        final int money = jsonObject.get("money").getAsInt();
        final int all_sr = jsonObject.get("all_sr").getAsInt();
        final int all_zc=jsonObject.get("all_zc").getAsInt();

        Sr[] srs=context.deserialize(jsonObject.get("srs"), Sr[].class);
        Zc[] zcs =context.deserialize(jsonObject.get("zcs"),Zc[].class);
        Ht[] hts = context.deserialize(jsonObject.get("hts"),Ht[].class);

        final User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setAll_sr(all_sr);
        user.setMoney(money);
        user.setAll_zc(all_zc);
        user.setSrs(srs);
        user.setZcs(zcs);
        user.setHts(hts);

        return user;
    }
    public User userDe(){
        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.serializeNulls();
        gsonBuilder.registerTypeAdapter(User.class,new UserDeserializer());
        gsonBuilder.registerTypeAdapter(Sr.class,new SrDeserializer());
        gsonBuilder.registerTypeAdapter(Zc.class,new ZcDeserializer());
        gsonBuilder.registerTypeAdapter(Ht.class,new HtDeserializer());
        final Gson gson = gsonBuilder.create();

        String s=new  FileIO().read("user.json");
        final User user =gson.fromJson(s,User.class);
        return user;
    }
}
