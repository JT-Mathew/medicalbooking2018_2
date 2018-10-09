package c.hayeon.seproject.viewholder;

import android.view.View;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.thoughtbot.expandablecheckrecyclerview.viewholders.CheckableChildViewHolder;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

import c.hayeon.seproject.R;

public class TimeViewHolder extends ChildViewHolder  {
    Button timeBtn;

    TextView detail;

    public TimeViewHolder(View itemView) {
        super(itemView);
        timeBtn = itemView.findViewById(R.id.timeBtn);
    }

    public void setTimeCTV(String name){
        timeBtn.setText(name);
    }

    public Button getTimeBtn() {
        return timeBtn;
    }
}
