package com.example.recyclerview1;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder> {

    private int lastPosition = -1;
    Context context;
    ArrayList<ContactModel> arrContact;

    RecyclerContactAdapter (Context context ,  ArrayList<ContactModel> arrContact){
        this.context = context;
        this.arrContact = arrContact;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.contact_row,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

    return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {


        holder.imgContact.setImageResource(arrContact.get(position).img);
        holder.txtName.setText(arrContact.get(position).name);
        holder.txtNumber.setText(arrContact.get(position).number);
        setAnimation(holder.itemView,position);

        holder.rawData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.add_update_lay);

                EditText editName = dialog.findViewById(R.id.edit_name);
                EditText editNo = dialog.findViewById(R.id.edit_no);
                Button btnAction = dialog.findViewById(R.id.btn_save);
                TextView textView = dialog.findViewById(R.id.textView);

                editName.setText((arrContact.get(position)).name);
                editNo.setText((arrContact.get(position)).number);


                textView.setText("Update Contact");
                btnAction.setText("Update");



                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String number = null;
                        String name = null;
                        if (!editName.getText().toString().equals("") && !editNo.getText().toString().equals("")) {
                            name = "";
                            number = "";

                            name = editName.getText().toString();

                            number = editNo.getText().toString();


                        } else {
                            Toast.makeText(context, "enter name and number", Toast.LENGTH_SHORT).show();
                        }

                        arrContact.set(position, new ContactModel(arrContact.get(position).img,name, number));
                        notifyItemChanged(position);

                        dialog.dismiss();

                    }
                });

                dialog.show();

            }
        });

        holder.rawData.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context )
                        .setTitle("Delete Contact")
                        .setMessage("Are you sure want to delete?")
                        .setIcon(R.drawable.ic_baseline_delete_24)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                arrContact.remove(position);
                                notifyItemChanged(position);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                builder.show();
                return true;
            }
        });




    }

    @Override
    public int getItemCount() {
        return arrContact.size() ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName , txtNumber;
        ImageView imgContact;
        LinearLayout rawData;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txt_name);
            txtNumber = itemView.findViewById(R.id.txt_number);
            imgContact = itemView.findViewById(R.id.image_corner);
            rawData = itemView.findViewById(R.id.raw_data);

        }
    }

    private void setAnimation(View viewToAnimate,int position){

        if (position > lastPosition){

            Animation slideIn = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(slideIn);
            lastPosition = position;

        }



    }

}
