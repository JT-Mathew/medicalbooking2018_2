package c.hayeon.seproject.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

import c.hayeon.seproject.R;
import c.hayeon.seproject.model.Time;
import c.hayeon.seproject.viewholder.DateViewHolder;
import c.hayeon.seproject.viewholder.TimeViewHolder;

public class DateAdapter extends ExpandableRecyclerViewAdapter<DateViewHolder, TimeViewHolder> {


    Context mContext;
    public DateAdapter(List<? extends ExpandableGroup> groups, Context context) {
        super(groups);
        mContext=context;
    }

    @Override
    public DateViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.date_parent, parent, false);
        return new DateViewHolder(view);
    }

    @Override
    public TimeViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.time_child, parent, false);
        return new TimeViewHolder(view);    }

    @Override
    public void onBindChildViewHolder(TimeViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        Time time = (Time) group.getItems().get(childIndex);
        String t = time.getHour() + ":" + time.getMin();
        holder.setTimeCTV(t);
        holder.getTimeBtn().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setTitle("Your title");
                builder.setMessage("your message ");
                builder.setPositiveButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.setNegativeButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // DO SOMETHING HERE

                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }


    @Override
    public void onBindGroupViewHolder(DateViewHolder holder, int flatPosition, ExpandableGroup group) {
        holder.setDate(group.getTitle());
    }
}
