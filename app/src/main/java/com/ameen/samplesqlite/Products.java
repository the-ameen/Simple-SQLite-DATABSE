package com.ameen.samplesqlite;

public class Products {
    private int _id;
    private String _productsname;

    public Products(){

    }

    public Products(String productsname) {
        this._productsname = productsname;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_productsname(String _productsname) {
        this._productsname = _productsname;
    }

    public int get_id() {
        return _id;
    }

    public String get_productsname() {
        return _productsname;
    }
}
