package a.childish_tales.recyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import a.childish_tales.activtiy.AudioPlayerActivity;
import a.childish_tales.R;
import a.childish_tales.activtiy.ListViewActivity;
import a.childish_tales.activtiy.WebViewActivity;
import a.childish_tales.recyclerview.multi.MultiItem;
import a.childish_tales.util.view.ColorUtil;

public class AdapterSliderLakcheri extends RecyclerView.Adapter<AdapterSliderLakcheri.ViewHolder>{

  private ArrayList<MultiItem> itemIntroList;
  private LayoutInflater mInflater;
  private Context mContext;

  // data is passed into the constructor
  public AdapterSliderLakcheri(Context context, ArrayList<MultiItem> itemIntroList) {
    this.mContext = context;
    this.mInflater = LayoutInflater.from(context);
    this.itemIntroList = itemIntroList;
  }

  // inflates the row layout from xml when needed
  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = mInflater.inflate(R.layout.item_slider_lackcheri, parent, false);
    return new ViewHolder(view);
  }

  // binds the data to the TextView in each row
  @SuppressLint("SetTextI18n")
  @Override
  public void onBindViewHolder(ViewHolder holder, final int position) {
    MultiItem item = itemIntroList.get(position);

    Glide.with(mContext).load(item.getStory_image()).into(holder.imageView);
    holder.title.setText(item.getStory_title());
    holder.desc.setText(item.getStory_desc());
    ColorUtil.setGradient(holder.box_detail,"#00000000","#333333");
    holder.view.setOnClickListener(clickListener(item));

  }

  // total number of rows
  @Override
  public int getItemCount() {
    return itemIntroList.size();
  }


  // stores and recycles views as they are scrolled off screen
  public class ViewHolder extends RecyclerView.ViewHolder{
      View view,box_detail;
      ImageView imageView;
      TextView title,desc;
    ViewHolder(View itemView) {
      super(itemView);
      view = itemView;
      imageView = itemView.findViewById(R.id.image);
      title = itemView.findViewById(R.id.title);
      desc = itemView.findViewById(R.id.desc);
      box_detail = itemView.findViewById(R.id.box_detail);
    }
  }

  private Intent intent = null;
  void setIntent(MultiItem object){
    switch (object.getOn_click()){
      case "audio":
        intent = new Intent(mContext, AudioPlayerActivity.class);
        intent.putExtra("title",object.getStory_title());
        intent.putExtra("desc",object.getStory_desc());
        intent.putExtra("image",object.getStory_image());
        intent.putExtra("sound_name",object.getStory_soundName());
        intent.putExtra("sound",object.getStory_sound());
        break;
      case "web_view":
        intent = new Intent(mContext, WebViewActivity.class);
        intent.putExtra("url",object.getUrl());
        break;
      case "browser":
        intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(object.getUrl()));
        break;
      case "json":
        intent = new Intent(mContext, ListViewActivity.class);
        intent.putExtra("url",object.getUrl());
        break;
      default:
        intent = null;
        break;
    }
  }

  View.OnClickListener clickListener(MultiItem object){
    return view -> {
      setIntent(object);
      if (intent !=null){
        (mContext).startActivity(intent);
      }
    };
  }
}