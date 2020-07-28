package org.example;

public interface MenuInterface {
    void addSabMenu(Menu menu);

    void getChild(int index);

    void make(MakeInterface makeInterface);

    void doIt(Context context);

    void remove(Menu menu);
}
