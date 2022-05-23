package com.mega.socialkunto.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mega.socialkunto.Adapter.NotificationAdapter;
import com.mega.socialkunto.Model.NotificationModel;
import com.mega.socialkunto.R;

import java.util.ArrayList;


public class Notification2Fragment extends Fragment {


    RecyclerView recyclerView;
    ArrayList<NotificationModel> list;

    public Notification2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_notification2, container, false);
        recyclerView=view.findViewById(R.id.notificationRV);
        list = new ArrayList<>();

        list.add(new NotificationModel(R.drawable.dua_profile_img,"<b>sudhir</b> Yup This was nice day","just now"));

        NotificationAdapter adapter = new NotificationAdapter(list,getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return view;
    }
}