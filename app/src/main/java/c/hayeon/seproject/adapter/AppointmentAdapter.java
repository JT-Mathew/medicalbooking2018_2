package c.hayeon.seproject.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import c.hayeon.seproject.R;
import c.hayeon.seproject.model.Appointment;
import c.hayeon.seproject.viewholder.AppointmentViewHolder;

public class AppointmentAdapter extends RecyclerView.Adapter<AppointmentViewHolder> {

    List<Appointment> mAppointmentList;

    public AppointmentAdapter(List<Appointment> appointmentList) {
        mAppointmentList = appointmentList;
    }

    @Override

    public AppointmentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View appointmentView= inflater.inflate(R.layout.appointment_list, parent, false);
        return new AppointmentViewHolder(appointmentView);
    }

    @Override
    public void onBindViewHolder( AppointmentViewHolder holder, int position) {
        for(Appointment app: mAppointmentList) {
            holder.setDateTv(app.getDate());
            holder.setTimeTv(app.getTime());
            holder.setDoctorTv(app.getDoc());
            holder.setLocationTv("Blah Testing Building 11");
        }

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
