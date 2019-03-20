package com.example.user.headerdetailrecyclerview;

import android.app.PendingIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Schedule> listSchedule;
    ArrayList<ISchedule> listScheduleInterface;
    RecyclerView rvSchedule;
    MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listSchedule = new ArrayList<>();
        insertData();
        setData();

        adapter = new MainAdapter(MainActivity.this, listScheduleInterface);

        rvSchedule = (RecyclerView) findViewById(R.id.rvSchedule);
        rvSchedule.setHasFixedSize(true);
        rvSchedule.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        rvSchedule.setAdapter(adapter);

    }

    private void insertData()
    {
        int day = 1;
        int counter = 0;
        for(int i=0; i<12; i++){
            Schedule schedule = new Schedule();
            if(counter < 3){
                schedule.setDate("2019-03-" + day);
                counter++;
            }
            else{
                counter = 0;
                day++;
                schedule.setDate("2019-03-" + day);
            }
            schedule.setDescription("Description " + i);

            listSchedule.add(schedule);
        }
    }

    private void setData()
    {
        listScheduleInterface = new ArrayList<>();
        String currDate = "";
        for(int i=0; i<listSchedule.size(); i++){
            Schedule schedule = listSchedule.get(i);

            if(currDate.equals("") || !schedule.getDate().equals(currDate)){
                // SET HEADER
                ScheduleDate scheduleDate = new ScheduleDate();
                scheduleDate.setDate(schedule.getDate());
                listScheduleInterface.add(scheduleDate);
                listScheduleInterface.add(schedule);
                currDate = schedule.getDate();
            }
            else{
                // SET DETAIL
                listScheduleInterface.add(schedule);
            }
        }
    }
}
