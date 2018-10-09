package c.hayeon.seproject.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import c.hayeon.seproject.R;
import c.hayeon.seproject.model.Appointment;

public class AppointmentAdapter extends RecyclerView.Adapter<AppointmentAdapter.AppointmentViewHolder> {

    List<Appointment> mAppointmentList;

    public class AppointmentViewHolder extends RecyclerView.ViewHolder{
        TextView dateTv;
        TextView timeTv;
        TextView doctorTv;
        public AppointmentViewHolder(View itemView) {
            super(itemView);
            dateTv = itemView.findViewById(R.id.dateTv);
            timeTv = itemView.findViewById(R.id.timeTv);
            doctorTv = itemView.findViewById(R.id.doctorTv);
        }
    }

    public AppointmentAdapter(List<Appointment> appointmentList) {
        mAppointmentList = appointmentList;
    }

    @Override

    public AppointmentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View appointmentView= LayoutInflater.from(parent.getContext()).
                inflate(R.layout.appointment_list, parent, false);
        return new AppointmentViewHolder(appointmentView);
    }

    @Override
    public void onBindViewHolder( AppointmentViewHolder holder, int position) {
        holder.dateTv.setText(mAppointmentList.get(position).getDate());
        holder.timeTv.setText(mAppointmentList.get(position).getTime());
        holder.doctorTv.setText(mAppointmentList.get(position).getDoc());
    }

    @Override
    public int getItemCount() {
        return mAppointmentList.size();
    }


}
