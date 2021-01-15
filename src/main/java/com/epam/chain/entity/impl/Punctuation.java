package com.epam.chain.entity.impl;

import com.epam.chain.entity.Component;

import java.util.List;

public class Punctuation implements Component {
    private char punctuationMark;
    public Punctuation(char punctuationMark){
        this.punctuationMark = punctuationMark;
    }
    @Override
    public void operation() {

    }

    @Override
    public void add(Component c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Component c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Component getChild(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return 1;
    }

    @Override
    public List<Component> getList() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return String.valueOf(punctuationMark);
    }
}
