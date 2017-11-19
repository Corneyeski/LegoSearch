package com.example.alanv.legosearch;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by alanv on 18/11/2017.
 */

class Box {
    Long id;
    String name;
    int parts;
    LocalDate realeased;

    public Box() {
    }

    public Box(Long id, String name, int parts, LocalDate realeased) {
        this.id = id;
        this.name = name;
        this.parts = parts;
        this.realeased = realeased;
    }

    Map<String, Object> toMap() {
        HashMap<String,Object> map = new HashMap<>();

        map.put("id",id);
        map.put("name",name);
        map.put("parts",parts);
        map.put("realeased",realeased);

        return map;
    }
}
