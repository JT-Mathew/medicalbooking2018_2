package c.hayeon.seproject.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import c.hayeon.seproject.R;

public class AppointmentViewHolder extends RecyclerView.ViewHolder {
    TextView dateTv;
    TextView timeTv;
    TextView doctorTv;
    TextView locationTv;

    public AppointmentViewHolder(View itemView) {
        super(itemView);
        dateTv = itemView.findViewById(R.id.dateTv);
        timeTv = itemView.findViewById(R.id.timeTv);
        doctorTv = itemView.findViewById(R.id.doctorTv);
        locationTv = itemView.findViewById(R.id.locationTv);
    }

    public void setDateTv(String text) {
        dateTv.setText(text);
    }

    public void setTimeTv(String text) {
        timeTv.setText(text);
    }

    public void setDoctorTv(String text) {
        doctorTv.setText(text);
    }

    public void setLocationTv(String text) {
        locationTv.setText(text);
    }
}
