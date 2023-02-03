package com.example.recyclerview1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ContactModel> arrContact = new ArrayList<>();
    RecyclerContactAdapter adapter;
    FloatingActionButton btnOpenDia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_contact);
        btnOpenDia =  findViewById(R.id.btmOptionDialog);

        btnOpenDia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_update_lay);
                EditText editName = dialog.findViewById(R.id.edit_name);
                EditText editNo = dialog.findViewById(R.id.edit_no);
                Button btnAction = dialog.findViewById(R.id.btn_save);

                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        
                        
                        if (!editName.getText().toString().equals("") && !editNo.getText().toString().equals("") ){
                            String name= "", number = "";

                            name = editName.getText().toString();

                            number = editNo.getText().toString();

                            arrContact.add(new ContactModel(R.drawable.man,name , number));
                            adapter.notifyItemInserted(arrContact.size()-1);
                            recyclerView.scrollToPosition(arrContact.size()-1);

                            dialog.dismiss();


//                            if (!editName.getText().toString().equals("")  ){
//                                name = editName.getText().toString();
//
//                            }
//                            else {
//                                Toast.makeText(MainActivity.this, "please enter name", Toast.LENGTH_SHORT).show();
//                            }
//
//                            if (!editNo.getText().toString().equals("")){
//                                number = editNo.getText().toString();
//                            }
//                            else {
//                                Toast.makeText(MainActivity.this, "please enter number", Toast.LENGTH_SHORT).show();
//                            }
//                            arrContact.add(new ContactModel(name , number));
//                            adapter.notifyItemInserted(arrContact.size()-1);
//                            recyclerView.scrollToPosition(arrContact.size()-1);
                        }
                        else {
                            Toast.makeText(MainActivity.this, "enter name and number", Toast.LENGTH_SHORT).show();
                        }



                    }
                });

                dialog.show();

            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        arrContact.add(new ContactModel(R.drawable.man,"A","9023812604"));
        arrContact.add(new ContactModel(R.drawable.man,"B","9023812604"));
        arrContact.add(new ContactModel(R.drawable.man,"C","9023812604" ));
        arrContact.add(new ContactModel(R.drawable.man,"D","9023812604"));
        arrContact.add(new ContactModel(R.drawable.man,"E","9023812604"));
        arrContact.add(new ContactModel(R.drawable.man,"F","9023812604" ));
        arrContact.add(new ContactModel(R.drawable.man,"G","9023812604"));
        arrContact.add(new ContactModel(R.drawable.man,"H","9023812604"));
        arrContact.add(new ContactModel(R.drawable.man,"I","9023812604" ));
        arrContact.add(new ContactModel(R.drawable.man,"J","9023812604" ));
        arrContact.add(new ContactModel(R.drawable.man,"K","9023812604" ));
        arrContact.add(new ContactModel(R.drawable.man,"L","9023812604" ));
        arrContact.add(new ContactModel(R.drawable.man,"M","9023812604" ));
        arrContact.add(new ContactModel(R.drawable.man,"N","9023812604" ));
        arrContact.add(new ContactModel(R.drawable.man,"O","9023812604"));
        arrContact.add(new ContactModel(R.drawable.man,"P","9023812604"));
        arrContact.add(new ContactModel(R.drawable.man,"Q","9023812604" ));
        arrContact.add(new ContactModel(R.drawable.man,"R","9023812604"));
        arrContact.add(new ContactModel(R.drawable.man,"S","9023812604"));
        arrContact.add(new ContactModel(R.drawable.man,"T","9023812604" ));
        arrContact.add(new ContactModel(R.drawable.man,"U","9023812604"));
        arrContact.add(new ContactModel(R.drawable.man,"V","9023812604"));
        arrContact.add(new ContactModel(R.drawable.man,"W","9023812604" ));
        arrContact.add(new ContactModel(R.drawable.man,"X","9023812604" ));
        arrContact.add(new ContactModel(R.drawable.man,"Y","9023812604" ));
        arrContact.add(new ContactModel(R.drawable.man,"Z","9023812604" ));
        arrContact.add(new ContactModel(R.drawable.man,"A","9023812604" ));
        arrContact.add(new ContactModel(R.drawable.man,"B","9023812604" ));

         adapter = new RecyclerContactAdapter(this ,arrContact);
        recyclerView.setAdapter(adapter);

    }
}