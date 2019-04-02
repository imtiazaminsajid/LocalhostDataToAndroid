package com.example.localhosttoandroiddataparsing;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.holder>{

    //--initialize global variable--//
    private List<Model> studentlist;
    private Context context;


    //--step:2 define constructor--//
    public Adapter(List<Model> studentlist, Context context) {
        this.studentlist = studentlist;
        this.context = context;
    }

    //---override method--//

    @Override
    public holder onCreateViewHolder(ViewGroup parent, int viewType) {
        //--binding data--//
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout,parent,false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(holder holder,final int position) {
        holder.name.setText(studentlist.get(position).getName());
        holder.rollno.setText(studentlist.get(position).getRoll());

    }

    @Override
    public int getItemCount() {
        return studentlist.size();
    }

    //--step 1: initialize a holder clss with viewholder--//

    class holder extends RecyclerView.ViewHolder
    {
        //--initialize variable--//
        TextView name;
        TextView rollno;



        public holder(View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.nameId);
            rollno=itemView.findViewById(R.id.rollId);

        }
    }
}
