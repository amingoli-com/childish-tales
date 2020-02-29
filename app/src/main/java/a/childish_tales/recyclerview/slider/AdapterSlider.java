package a.childish_tales.recyclerview.slider;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import a.childish_tales.activtiy.InfoStoryActivity;
import a.childish_tales.R;
import a.childish_tales.util.view.ViewUtil;

public class AdapterSlider extends RecyclerView.Adapter<AdapterSlider.ViewHolder>{

  private ArrayList<ItemSlider> itemIntroList;
  private LayoutInflater mInflater;
  private Context context;

  // data is passed into the constructor
  public AdapterSlider(Context context, ArrayList<ItemSlider> itemIntroList) {
    this.context = context;
    this.mInflater = LayoutInflater.from(context);
    this.itemIntroList = itemIntroList;
  }

  // inflates the row layout from xml when needed
  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = mInflater.inflate(R.layout.item_slider, parent, false);
    return new ViewHolder(view);
  }

  // binds the data to the TextView in each row
  @SuppressLint("SetTextI18n")
  @Override
  public void onBindViewHolder(ViewHolder holder, final int position) {
    ItemSlider item = itemIntroList.get(position);
    ViewUtil.setImageResource(context,holder.imageView,item.getImage());

    holder.title.setText(item.getTitle());
    holder.desc.setText(item.getDesc());
    holder.writer_narrator.setText(item.getWriter()+", "+item.getNarrator());
    holder.time.setText(item.getTime());



    if (item.getStar()>0){
      for (int i = 0; i < item.getStar(); i++) {
        /*holder.star.append("⭐️");*/
      }
    }

    holder.view.setOnClickListener(view -> {
      Intent intent = new Intent(context, InfoStoryActivity.class);
      intent.putExtra("image",item.getImage());
      intent.putExtra("audio",item.getSound_file());
      intent.putExtra("title",item.getTitle());
      intent.putExtra("desc",item.getDesc());
      intent.putExtra("writer",item.getWriter());
      intent.putExtra("narrator",item.getNarrator());
      intent.putExtra("time",item.getTime());
      intent.putExtra("star",item.getStar());
      context.startActivity(intent);
    });
  }

  // total number of rows
  @Override
  public int getItemCount() {
    return itemIntroList.size();
  }


  // stores and recycles views as they are scrolled off screen
  public class ViewHolder extends RecyclerView.ViewHolder{
      View view;
      ImageView imageView;
      TextView title,star,desc,text,writer_narrator,time;
    ViewHolder(View itemView) {
      super(itemView);
      view = itemView;
      imageView = itemView.findViewById(R.id.image);
      title = itemView.findViewById(R.id.title);
      time = itemView.findViewById(R.id.time);
      desc = itemView.findViewById(R.id.desc);
      writer_narrator = itemView.findViewById(R.id.writer_narrator);
    }
  }
  boolean urlIsTrue(String url){
    if (url!=null &&
        url.length()>3 &&
        url.startsWith("http")){
      return true;
    }
    return false;
  }
}