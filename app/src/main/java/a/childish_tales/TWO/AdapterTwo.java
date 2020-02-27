package a.childish_tales.TWO;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import a.childish_tales.MAIN.ItemMain;
import a.childish_tales.R;

public class AdapterTwo extends RecyclerView.Adapter<AdapterTwo.ViewHolder>{

  private ArrayList<ItemTwo> itemIntroList;
  private LayoutInflater mInflater;
  private Context context;

  // data is passed into the constructor
  public AdapterTwo(Context context, ArrayList<ItemTwo> itemIntroList) {
    this.context = context;
    this.mInflater = LayoutInflater.from(context);
    this.itemIntroList = itemIntroList;
  }

  // inflates the row layout from xml when needed
  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = mInflater.inflate(R.layout.item, parent, false);
    return new ViewHolder(view);
  }

  // binds the data to the TextView in each row
  @Override
  public void onBindViewHolder(ViewHolder holder, final int position) {
    ItemTwo item = itemIntroList.get(position);
    holder.imageView.setImageResource(item.getImage());
  }

  // total number of rows
  @Override
  public int getItemCount() {
    return itemIntroList.size();
  }


  // stores and recycles views as they are scrolled off screen
  public class ViewHolder extends RecyclerView.ViewHolder{
      ImageView imageView;
    ViewHolder(View itemView) {
      super(itemView);
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