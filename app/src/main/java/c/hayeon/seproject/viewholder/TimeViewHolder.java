package c.hayeon.seproject.viewholder;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

import c.hayeon.seproject.R;

public class TimeViewHolder extends ChildViewHolder {
    Button nineBtn;
    Button nineHalfBtn;
    Button tenBtn;
    Button tenHalfBtn;

    public TimeViewHolder(View itemView) {
        super(itemView);
        nineBtn = itemView.findViewById(R.id.nineBtn);
        nineHalfBtn = itemView.findViewById(R.id.nineHalfBtn);
        tenBtn = itemView.findViewById(R.id.tenBtn);
       tenHalfBtn = itemView.findViewById(R.id.tenHalfBtn);
    }

    public void setNineBtn(String time){

        nineBtn.setText(time);
    }
}
