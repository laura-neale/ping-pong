package com.github.lauraneale;

public class Coordinator {

    private boolean flag;

    public void flipFlag(){
        this.flag = !flag;
    }

    public boolean getPinged(){
        return this.flag;
    }
}
