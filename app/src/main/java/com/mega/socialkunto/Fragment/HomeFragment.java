package com.mega.socialkunto.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.ArrayRes;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mega.socialkunto.Adapter.DashboardAdapter;
import com.mega.socialkunto.Adapter.StoryAdapter;
import com.mega.socialkunto.Model.DashboardModel;
import com.mega.socialkunto.Model.StoryModel;
import com.mega.socialkunto.NotificationActivity;
import com.mega.socialkunto.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class HomeFragment extends Fragment {

    TextView heading;
    RecyclerView storyRv,dashboardRV;
    ArrayList<StoryModel> list;
    ArrayList<DashboardModel> dashboardList;
    ImageView notification;
    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);

        heading=view.findViewById(R.id.heading);
        notification=view.findViewById(R.id.notification);

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), NotificationActivity.class);
                startActivity(intent);

            }
        });


        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss a");
        String formattedDate = df.format(c.getTime());

        if (formattedDate.contains("AM")) {
            heading.setText("Good Morning");
        } else {
            heading.setText("Good Evening");
        }
        storyRv=view.findViewById(R.id.storyRV);
        list= new ArrayList<>();

        list.add(new StoryModel(R.drawable.dua_lipa_profile,R.drawable.live,R.drawable.dua_status,"dua lipa"));
        list.add(new StoryModel(R.drawable.dua_lipa_profile,R.drawable.live,R.drawable.dua_status,"dua lipa"));
        list.add(new StoryModel(R.drawable.dua_lipa_profile,R.drawable.live,R.drawable.dua_status,"dua lipa"));
        list.add(new StoryModel(R.drawable.dua_lipa_profile,R.drawable.live,R.drawable.dua_status,"dua lipa"));

        StoryAdapter adapter = new StoryAdapter(list,getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        storyRv.setLayoutManager(linearLayoutManager);
        storyRv.setNestedScrollingEnabled(false);
        storyRv.setAdapter(adapter);



        dashboardRV=view.findViewById(R.id.dashboardRv);
        dashboardList = new ArrayList<>();
        dashboardList.add(new DashboardModel(R.drawable.dua_lipa_profile,R.drawable.dua_status,R.drawable.saved,"Dua Lipa","traveler","464","12","15"));
        dashboardList.add(new DashboardModel(R.drawable.dua_status,R.drawable.dua_profile_img,R.drawable.saved,"Dua Lipa","dancer","530","1223","1533"));

        DashboardAdapter dashboardAdapter = new DashboardAdapter(dashboardList,getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        dashboardRV.setLayoutManager(layoutManager);
        dashboardRV.setNestedScrollingEnabled(false);
        dashboardRV.setAdapter(dashboardAdapter);
        return view;

    }
}