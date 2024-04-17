package com.example.cikitsam;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;


    // CustomDialogFragment.java
    public class CustomDialogFragment extends DialogFragment {

        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

            // Set the title and message
            builder.setTitle("Logout")
                    .setMessage("Are you sure you want to logout?");

            // Add buttons with actions
            builder.setPositiveButton("Logout", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    Intent intent = new Intent(getActivity(), login.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    getActivity().finish(); // Handle logout action if needed
                   // You can call a logout method or perform any other action here
                }
            });

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // Handle cancel action if needed
                    // This will close the dialog without logging out
                    dialog.dismiss();
                }
            });

            return builder.create();
        }
    }



