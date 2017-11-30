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
    LocalDate released;
    String urlImage;

    public Box() {
    }

    public Box(Long id, String name, int parts, LocalDate released, String urlImage) {
        this.id = id;
        this.name = name;
        this.parts = parts;
        this.released = released;
    }

    Map<String, Object> toMap() {
        HashMap<String,Object> map = new HashMap<>();

        map.put("id",id);
        map.put("name",name);
        map.put("parts",parts);
        map.put("released", released);

        return map;
    }
}
