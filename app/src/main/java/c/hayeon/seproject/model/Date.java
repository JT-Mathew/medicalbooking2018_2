package c.hayeon.seproject.model;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class Date extends ExpandableGroup {
    public Date(String title, List<Time> items) {
        super(title, items);
    }
}
