package com.example.bridgelabz.popuplist;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.R.string;

/**
 * Created by bridgelabz on 12/12/15.
 */
public class PopUp extends DialogFragment {
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        AlertDialog.Builder helpBuilder = new AlertDialog.Builder(getActivity());
        helpBuilder.setTitle("POP Message");
        helpBuilder.setMessage("This is the popo up message box");
        helpBuilder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        Dialog helpDialog =  helpBuilder.create();
        return helpDialog;
    }


}

