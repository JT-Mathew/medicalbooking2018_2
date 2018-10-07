package c.hayeon.seproject.viewholder;

import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import c.hayeon.seproject.R;

public class DateViewHolder extends GroupViewHolder {
    private TextView timeTv;
    public DateViewHolder(View itemView) {
        super(itemView);
        timeTv = itemView.findViewById(R.id.timeTv);
    }

    public void setDate(String date){
        timeTv.setText(date);

    }
}
