package com.example.authorization.models;

import lombok.Builder;
import lombok.Data;

// javafaker позволяет генерировать случайные числа
@Data
@Builder
public class Application {
    private int id;
    private String name;
    private String author;
    private String version;
}
