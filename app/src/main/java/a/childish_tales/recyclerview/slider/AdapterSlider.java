package a.childish_tales.recyclerview.slider;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import a.childish_tales.InfoStoryActivity;
import a.childish_tales.R;

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
  @Override
  public void onBindViewHolder(ViewHolder holder, final int position) {
    ItemSlider item = itemIntroList.get(position);
    holder.imageView.setImageResource(item.getImage());
    holder.view.setOnClickListener(view -> {
      Intent intent = new Intent(context, InfoStoryActivity.class);
      intent.putExtra("image",item.getImage());
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
    ViewHolder(View itemView) {
      super(itemView);
      view = itemView;
      imageView = itemView.findViewById(R.id.image);
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