package com.coaching.coaching.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;


@Component
@Getter
@Setter
@ToString
@Document (collection = "students")
public class Student {
    @Id
    private int sid;
    private String sname;
    private String course;
}

