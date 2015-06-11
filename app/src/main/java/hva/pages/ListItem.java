package hva.pages;

import java.net.URI;
import java.net.URL;

//Class which describes what form have the items in the list

public class ListItem {
    public String icon;
    public String title;
    public ListItem(){
        super();
    }

    public ListItem(String icon, String title) {
        super();
        this.title = title;
        this.icon = icon;
    }
}
