package com.example.phonebookprojecy728;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<Contact> {

    private Context mainContext;
    private int adapterXML;
    private List<Contact> contactList;

    public CustomAdapter(Context context, int resource, List<Contact> objects) {
        super(context, resource, objects);
        this.mainContext = context;
        this.adapterXML = resource;
        this.contactList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mainContext).inflate(adapterXML, parent, false);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.id_imageview);
            holder.topText = convertView.findViewById(R.id.id_textview);
            holder.bottomText = convertView.findViewById(R.id.id_textviewpn);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Contact contact = contactList.get(position);
        holder.imageView.setImageResource(contact.getImageId());
        holder.topText.setText(contact.getName());
        holder.bottomText.setText(contact.getPhoneNumber());

        return convertView;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView topText;
        TextView bottomText;
    }
}

