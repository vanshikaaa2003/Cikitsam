package com.example.cikitsam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class FAQs extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MessageAdapter messageAdapter;
    private Button sendButton;
    String selected_item;
    String[] items = {"Customer Support","Technical Issues","Contact Us","Email Us","Updates or New Features","Connectivity Issue","Historical Data Record","Privacy"};
    AutoCompleteTextView autoCompleteTxt;
    ArrayAdapter<String> adapterItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faqs);
        autoCompleteTxt = findViewById(R.id.auto_complete_txt);
        recyclerView = findViewById(R.id.recyclerViewss);
        sendButton = findViewById(R.id.sendButton);

        adapterItems = new ArrayAdapter<String>(this,R.layout.list_item,items);
        autoCompleteTxt.setAdapter(adapterItems);
        autoCompleteTxt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selected_item = adapterView.getItemAtPosition(i).toString();
            }
        });


        List<message> messageList = new ArrayList<>();
        messageAdapter = new MessageAdapter(messageList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(messageAdapter);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userMessage = selected_item;
                if (!userMessage.isEmpty()) {
                    // Add user message to RecyclerView
                    messageAdapter.addMessage(new message(userMessage, true));

                    // Generate and add assistant's response
                    String assistantResponse = generateAssistantResponse(userMessage);
                    messageAdapter.addMessage(new message(assistantResponse, false));


                    // Scroll to latest message
                    recyclerView.smoothScrollToPosition(messageAdapter.getItemCount() - 1);
                }
            }
        });
    }
    private String generateAssistantResponse(String userMessage) {
        // Implement your logic to generate assistant's response based on user's message
        // For simplicity, using fixed responses here
        switch (userMessage.toLowerCase()) {
            case "Customer Support":
                return "You can directly mail us and get your query reply within 2-3 hours.";
            case "Technical Issues":
                return "You can get in touch with our techinal expert by mailing us.";
            case "Contant Us":
                return "You can get in touch with 9818547022";
            case "Email Us":
                return "You can get in touch with cikitsam@gmail.com";
            case "Updates or New Features":
                return "Ofcourse we are working at our best to provide more and more features you will be notified when updated.";
            case "Connectivity Issue":
                return "You can check wether the band is tightly tie at your wrist or there is no obstacles with the wrist and the band and also most important check your internet connectivity.";
            case "Historical Data Record":
                return "You can see your past history under the past history section and sorry to say you can't export any of your data.";
            case "Privacy":
                return "Yes for sure your health data is secured and all the data is safely stored in the cloud server.";
            default:
                return "I'm sorry, I can't understand that for that you can record your query and send it to our email";
        }
    }
}