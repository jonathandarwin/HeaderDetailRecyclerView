package com.example.user.headerdetailrecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by User on 3/3/2019.
 */

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    ArrayList<ISchedule> listScheduleInterface;
    Context mContext;
    String currDate = "";
    private static final int HEADER = 1;
    private static final int DETAIL = 2;

    public MainAdapter(Context mContext, ArrayList<ISchedule> listScheduleInterface){
        this.mContext = mContext;
        this.listScheduleInterface = listScheduleInterface;
    }

    public static class ViewHolderHeader extends RecyclerView.ViewHolder{
        TextView tvDate;
        public ViewHolderHeader(View itemView) {
            super(itemView);
            tvDate = (TextView) itemView.findViewById(R.id.tvDate);
        }
    }

    public static class ViewHolderDetail extends RecyclerView.ViewHolder{
        TextView tvDescription;
        public ViewHolderDetail(View itemView) {
            super(itemView);
            tvDescription = (TextView) itemView.findViewById(R.id.tvDescription);
        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = null;
        if(viewType == ISchedule.HEADER){
            view = inflater.inflate(R.layout.list_header_item, parent, false);
            return new ViewHolderHeader(view);
        }
        else if (viewType == ISchedule.DETAIL){
            view = inflater.inflate(R.layout.list_detail_item, parent, false);
            return new ViewHolderDetail(view);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if(listScheduleInterface.get(position).getType() == ISchedule.HEADER){
            // SET HEADER
            ScheduleDate scheduleDate = (ScheduleDate) listScheduleInterface.get(position);
            ((ViewHolderHeader) holder).tvDate.setText(scheduleDate.getDate());
        }
        else{
            // SET DETAIL
            Schedule schedule = (Schedule) listScheduleInterface.get(position);
            ((ViewHolderDetail) holder).tvDescription.setText(schedule.getDescription());
        }
    }

    @Override
    public int getItemCount() {
        return listScheduleInterface.size();
    }

    @Override
    public int getItemViewType(int position) {
        return listScheduleInterface.get(position).getType();
    }

}
