package com.springboot.demo;

import com.google.gson.*;
import com.springboot.demo.model.User;
import org.junit.Test;

import java.lang.reflect.Type;

public class GsonTest {


    @Test
    public void TestOne() {
        JsonDeserializer<Integer> jsonDeserializer = new JsonDeserializer<Integer>() {
            @Override
            public Integer deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                try {
                    return json.getAsInt();
                } catch (NumberFormatException e) {
                    return 0;
                }
            }
        };


        try {

            String gsonString = "{\n" +
                    "    \"age\": \"\",\n" +
                    "    \"pwd\": \"123\"\n" +
                    "    \"name\": \"madio\"\n" +
                    "}";
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(int.class, jsonDeserializer)
                    .create();
            User fromJson = gson.fromJson(gsonString, User.class);
            System.out.println(fromJson);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
