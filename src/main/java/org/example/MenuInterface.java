package org.example;

public interface MenuInterface {
    void addSabMenu(Menu menu);

    void getChild(int index);

    void make(MakeInterface makeInterface);

    void remove(Menu menu);
}
