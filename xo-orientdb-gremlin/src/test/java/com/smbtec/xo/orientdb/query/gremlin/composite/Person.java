package com.smbtec.xo.orientdb.query.gremlin.composite;

import java.util.Collection;

import com.smbtec.xo.tinkerpop.blueprints.api.annotation.Vertex;

@Vertex
public interface Person {

    String getFirstname();

    void setFirstname(String firstName);

    String getLastname();

    void setLastname(String lastName);

    int getAge();

    void setAge(int age);

    Collection<Person> getFriends();

}
