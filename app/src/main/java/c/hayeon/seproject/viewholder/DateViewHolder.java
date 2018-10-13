package c.hayeon.seproject.viewholder;

import android.graphics.Color;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import c.hayeon.seproject.R;

public class DateViewHolder extends GroupViewHolder {
    private TextView timeTv;
    private RelativeLayout dateRl;
    public DateViewHolder(View itemView) {
        super(itemView);
        dateRl = itemView.findViewById(R.id.dateRl);
        timeTv = itemView.findViewById(R.id.timeTv);
    }

    public void setDate(String date){
        timeTv.setText(date);
    }

    public RelativeLayout getDateRl() {
        return dateRl;
    }

    public void highlight(){
        dateRl.setBackgroundColor(itemView.getResources().getColor(R.color.colorPoint));
        timeTv.setTextColor(itemView.getResources().getColor(R.color.colorGrey));
    }
}
