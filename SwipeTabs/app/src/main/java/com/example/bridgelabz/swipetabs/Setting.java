package com.example.bridgelabz.swipetabs;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by bridgelabz on 3/1/16.
 */
public class Setting extends Activity {

    ListView listView;
    String[] settings = new String[]{"Help","Profile","Account","Chats and calls","Notifications","Contacts"};
    int[] images = new int[]{R.drawable.help,R.drawable.profile,R.drawable.accounts,R.drawable.chats,R.drawable.notification,R.drawable.contacts};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_layout);
        listView = (ListView) findViewById(R.id.setting_listView);
        listView.setAdapter(new MyAdapter(this,settings,images));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (Integer.parseInt(listView.getItemAtPosition(position).toString()))
                {
                    case 0:
                        Intent help = new Intent(getBaseContext(),Help.class);
                        startActivity(help);
                        break;
                    case 1:
                        Toast.makeText(getBaseContext(),"Profile",Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(getBaseContext(),"Accounts",Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(getBaseContext(),"Chats and calls",Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(getBaseContext(),"Notification",Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        Toast.makeText(getBaseContext(),"Contacts",Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(getBaseContext(),"Wrong Choice",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }




}
