package org.example;

import java.util.ArrayList;
import java.util.List;

public class Menu implements MenuInterface {
    private String name;
    private List<Menu> menuList = new ArrayList<>();
    private Action<Context> action;
    private int count = 1;

    public Menu(String name) {
        this(name, null);
    }

    public Menu(String name, Action<Context> action) {
        this.name = name;
        this.action = action;
    }

    @Override
    public void addSabMenu(Menu menu) {
        menuList.add(menu);
    }

    @Override
    public void getChild(int index) {
        menuList.get(index);

    }


    public void print() {
        for (Menu subMenu : menuList) {
            System.out.println(count + "- " + subMenu.name);
            count++;
        }
        count = 1;

    }



    @Override
    public void make(MakeInterface makeInterface) {
        makeInterface.doIt();
    }

    @Override
    public void doIt(Context context) {
        action.doIt(context);
    }

    @Override
    public void remove(Menu menu) {
        menuList.remove(menu);

    }

    @Override
    public String toString() {
        return name;
    }
}
