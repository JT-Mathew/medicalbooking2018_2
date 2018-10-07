package c.hayeon.seproject.adapter;

import android.view.ViewGroup;

import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

import c.hayeon.seproject.viewholder.DateViewHolder;
import c.hayeon.seproject.viewholder.TimeViewHolder;

public class DateAdapter extends ExpandableRecyclerViewAdapter<DateViewHolder, TimeViewHolder> {
    public DateAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public DateViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public TimeViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindChildViewHolder(TimeViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {

    }

    @Override
    public void onBindGroupViewHolder(DateViewHolder holder, int flatPosition, ExpandableGroup group) {

    }
}
