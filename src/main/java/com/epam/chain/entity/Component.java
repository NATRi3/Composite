package com.epam.chain.entity;

import java.util.List;

public interface Component{
    void operation();
    void add(Component c);
    void remove(Component c);
    Component getChild(int index);
    int size();
    List<Component> getList();
}
