package com.example.cikitsam;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    private TextView nameTextView, ageTextView, usernameTextView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        CardView personal = view.findViewById(R.id.personal);
        CardView settings = view.findViewById(R.id.settings);
        CardView pasthistory = view.findViewById(R.id.past_his);
        CardView faqs = view.findViewById(R.id.quesans);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event here
                onCardViewClicked();
            }

            private void onCardViewClicked() {
                Intent n = new Intent(getActivity(),Setting.class);
                startActivity(n);
            }
        });
        personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event here
                onCardViewClicked();
            }

            private void onCardViewClicked() {
                Intent n = new Intent(getActivity(),Personal_Details.class);
                startActivity(n);
            }
        });
        pasthistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event here
                onCardViewClicked();
            }

            private void onCardViewClicked() {
                Intent n = new Intent(getActivity(),Past_History.class);
                startActivity(n);
            }
        });
        faqs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event here
                onCardViewClicked();
            }

            private void onCardViewClicked() {
                Intent n = new Intent(getActivity(),FAQs.class);
                startActivity(n);
            }
        });
       /* DatabaseHelper db = new DatabaseHelper(getActivity());
        nameTextView = view.findViewById(R.id.nameTextView);
        ageTextView = view.findViewById(R.id.ageTextView);
        usernameTextView = view.findViewById(R.id.usernameTextView);

        ArrayList<Detailmodel> arrDetails = db.fetchDetails();

        if (!arrDetails.isEmpty()) {
            Detailmodel detail = arrDetails.get(0); // Assuming you want the first detail

            // Set details in TextViews
            nameTextView.setText("Name: " + detail.getName());
            ageTextView.setText("Age: " + String.valueOf(detail.getAge()));
            usernameTextView.setText("Address: " + detail.getUsername());
        }*/


        // Inflate the layout for this fragment
        return view;
    }
}