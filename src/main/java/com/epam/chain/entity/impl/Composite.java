package com.epam.chain.entity.impl;

import com.epam.chain.entity.Component;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    private List<Component> componentList = new ArrayList<>();
    public Composite(){}
    public Composite(List<Component> componentList) {
        this.componentList = componentList;
    }

    @Override
    public void operation() {

    }

    @Override
    public void add(Component c) {
        componentList.add(c);
    }

    @Override
    public void remove(Component c) {
        componentList.remove(c);
    }

    @Override
    public Component getChild(int index) {
        return componentList.get(index);
    }

    @Override
    public int size() {
        return componentList.size();
    }

    @Override
    public List<Component> getList() {
        return new ArrayList<>(componentList);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder().append(componentList);
        sb.append(" ");
        return sb.toString();
    }
}
