package com.mycompany.blue;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import java.util.List;

public class Wraper<T> {

    private final Gson gson;

    public Wraper() {
        GsonBuilder builder = new GsonBuilder();
        //builder.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
        this.gson = builder
                .excludeFieldsWithoutExposeAnnotation()
                .serializeNulls()
                .setDateFormat("yyyy-MM-dd")
                .create();
    }
    
    public String reply(T t) {
        return this.gson.toJson(t);
    }
    
    public String listReply(List<T> t) {
        return this.gson.toJson(t);
    }
    
    public T parseFrom(JsonElement input, T t) {
        T tt = (T)this.gson.fromJson(input,t.getClass());
        return tt;
    }
    
}
