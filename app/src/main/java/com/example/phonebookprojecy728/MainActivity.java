package com.example.phonebookprojecy728;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textviewadapter;
    TextView textViewadadapter2;
    ListView listView;
    ArrayList<Contact> contact;
    TextView textView;
    TextView textView2;
    TextView textView3;
    ImageView imageView2;
    Button button;
    Button add;
    int position2;
    EditText email;
    EditText phoneNumber;
    EditText Name;
    Button submit;

    CustomAdapter customAdapter;

    static final String KEY_COUNT = "243567";



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.id_ListView);
        contact = new ArrayList<Contact>();
        email = findViewById(R.id.id_editEmail);
        Name = findViewById(R.id.id_editName);
        phoneNumber = findViewById(R.id.id_editPhoneNumber);
        submit = findViewById(R.id.id_submit);


        imageView = findViewById(R.id.id_imageview);
        textviewadapter = findViewById(R.id.id_textviewpn);
        textViewadadapter2 = findViewById(R.id.id_textview);

        textView = findViewById(R.id.id_horiTextView);
        textView2 = findViewById(R.id.id_horiTextView2);
        textView3 = findViewById(R.id.id_horiTextView3);
        imageView2 = findViewById(R.id.id_imageview3);
        button = findViewById(R.id.id_remove);
        add = findViewById(R.id.id_add);
        position2 = 0;


        if(savedInstanceState  !=  null)
        {
            contact = savedInstanceState.getParcelableArrayList(KEY_COUNT);

        } else {
            contact = new ArrayList<Contact>();
            contact.add(new Contact("Envy Adams", R.drawable.envy, "123-456-6969", "envy.adams@gmail.com", "87 Beverly Hills"));
            contact.add(new Contact("Gideon Graves", R.drawable.gideon, "123-420-6969", "gideon.graves@gmail.com", "86 Beverly Hills"));
            contact.add(new Contact("Kim Pine", R.drawable.kim, "420-694-6969", "kim.pine@gmail.com", "85 Beverly Hills"));
            contact.add(new Contact("Knives Chau", R.drawable.knives, "123-456-7939", "knives.chau@gmail.com","84 Beverly Hills"));
            contact.add(new Contact("Scott Pilgrim", R.drawable.scott, "743-666-3938", "scott.pilgrim@gmail.com", "83 Beverly Hills"));
            contact.add(new Contact("Ramona Flowers", R.drawable.ramona, "212-664-7665", "ramona.flowers@gmail.com", "82 Beverly Hills"));
            contact.add(new Contact("Roxine Richter", R.drawable.roxine, "764-567-8965", "roxine.richter@gmail.com", "81 Beverly Hills"));
            contact.add(new Contact("Wallace Wells", R.drawable.wallace, "745-897-3738", "wallace.wells@gmail.com", "80 Beverly Hills"));

        }

        customAdapter = new CustomAdapter(this, R.layout.adapter_layout, contact);
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MainActivity.this, "YOU SELECTED " + contact.get(position).getName(), Toast.LENGTH_SHORT).show();
                if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    textView.setText(contact.get(position).getEmail());
                    textView3.setText(contact.get(position).getAddress());
                    imageView2.setImageResource(contact.get(position).getImageId());
                    position2 = position;
                }
            }
        });



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Contact selectedcontact = contact.get(i);
                contact.remove(selectedcontact);
                contact.add(0, selectedcontact);
                customAdapter.notifyDataSetChanged();
                //positiontop = i;
                Toast.makeText(MainActivity.this, "YOU SELECTED " + contact.get(0).getName(), Toast.LENGTH_SHORT).show();
                if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    textView.setText(contact.get(0).getEmail());
                    textView3.setText(contact.get(0).getAddress());
                    imageView2.setImageResource(contact.get(0).getImageId());
                    //Toast.makeText(MainActivity.this, "YOU SELECTED " + contact.get(0).getName(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            update();
            remove();
        }
    }




    public void update(){
        if (contact.isEmpty())
        {
            textView.setText("NO CONTACT SELECTED");
            textView3.setText("NO CONTACT SELECTED");
            imageView2.setImageResource(R.drawable.questionmark);
        }
        else {
            textView.setText(contact.get(position2).getEmail());
            textView3.setText(contact.get(position2).getAddress());
            imageView2.setImageResource(contact.get(position2).getImageId());
        }
    }

    public void remove(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contact.remove(position2);
                customAdapter.notifyDataSetChanged();
                if(contact.isEmpty()) {
                    button.setClickable(false);

                }

                if(position2 >= contact.size()) {
                    position2--;
                }
                update();

            }
        });
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(KEY_COUNT, contact);
    }
}