package com.briup.product_source.bean.ext;

import com.briup.product_source.bean.basic.Animal;
import com.briup.product_source.bean.basic.Hurdles;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AnimalExt extends Animal {
    @JsonProperty("list")
    private List<Animal> animalList;
}
