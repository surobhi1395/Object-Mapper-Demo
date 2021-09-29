package com.objectmapper.demo.enums;

import static javax.print.attribute.standard.MediaSizeName.B;

public enum Modes {

    H("Hydrogen"),
    HE("Helium"),
    LI("Lithium"),
     BE("Berelium"),
    B("Boron"),
    C("Carbon"),
    N("Neon"),
    O("Oxygen");

    public final String elements;

    private Modes(String elements){
        this.elements=elements;
    }

}
