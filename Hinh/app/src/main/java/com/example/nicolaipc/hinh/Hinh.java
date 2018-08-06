package com.example.nicolaipc.hinh;

public class Hinh {
    public int _id;
    public String name;
    public byte[] img;

    public Hinh(int _id, String name, byte[] img) {
        this._id = _id;
        this.name = name;
        this.img = img;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }
}
