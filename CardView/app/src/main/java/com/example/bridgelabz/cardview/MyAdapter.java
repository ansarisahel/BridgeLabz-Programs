package com.example.bridgelabz.cardview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by bridgelabz on 12/1/16.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ContactViewHolder> {

    ArrayList<Contacts> contacts = new ArrayList<Contacts>();
    Context context;
    MyAdapter(ArrayList<Contacts> contacts,Context context)
    {
        this.contacts = contacts;
        this.context = context;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_row_layout,parent,false);
        ContactViewHolder contactViewHolder = new ContactViewHolder(view,context,contacts);
        return contactViewHolder;
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        Contacts contact = contacts.get(position);
            holder.name.setText(contact.getName());
            holder.email.setText(contact.getEmail());
            holder.mobileNumber.setText(contact.getMobileNumber());
            holder.image.setImageResource(contact.getImage());

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView name,mobileNumber,email;
        ImageView image;
        Context context;
        ArrayList<Contacts> contacts;
        public ContactViewHolder(View view,Context context,ArrayList<Contacts> contacts)
        {
            super(view);
            view.setOnClickListener(this);
            this.context = context;
            this.contacts = contacts;
            name = (TextView) view.findViewById(R.id.txtname);
            mobileNumber = (TextView) view.findViewById(R.id.txtMobileNumber);
            email = (TextView) view.findViewById(R.id.txtEmail);
            image = (ImageView) view.findViewById(R.id.imageView1);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Contacts selectedContact = contacts.get(position);
            Intent intent = new Intent(context,Contact_Detail.class);
            intent.putExtra("name",selectedContact.getName());
            intent.putExtra("image",selectedContact.getImage());
            intent.putExtra("email",selectedContact.getEmail());
            intent.putExtra("mobileNumber",selectedContact.getMobileNumber());
            context.startActivity(intent);
        }
    }
}
