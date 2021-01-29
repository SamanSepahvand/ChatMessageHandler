package com.samansepahvand.chatmessagehandler.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.samansepahvand.chatmessagehandler.MainActivity;
import com.samansepahvand.chatmessagehandler.R;
import com.samansepahvand.chatmessagehandler.model.ChatModel;
import com.samansepahvand.chatmessagehandler.util.Constant;

import org.w3c.dom.Text;

import java.util.List;

public class MyAdapter  extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


    private Context context;
    private List<ChatModel> chatModels;


    public MyAdapter(Context context, List<ChatModel> chatModels) {
        this.context = context;
        this.chatModels = chatModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.item_recyclerview,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ChatModel chatModel=chatModels.get(position);

        holder.txtId.setText(String.valueOf(chatModel.getId()));
        holder.txtTitle.setText(chatModel.getTitle());


    }

    @Override
    public int getItemCount() {

     //   return chatModels.size();
         int limit=10;
         return Math.min(chatModels.size(), Constant.limit);

    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private TextView txtId;
        private  TextView txtTitle;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            txtId=itemView.findViewById(R.id.txt_id);

            txtTitle=itemView.findViewById(R.id.txt_title);

        }
    }
}
