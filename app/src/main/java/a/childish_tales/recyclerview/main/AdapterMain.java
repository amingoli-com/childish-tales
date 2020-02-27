package a.childish_tales.recyclerview.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.dingmouren.layoutmanagergroup.skidright.SkidRightLayoutManager;

import java.util.List;

import a.childish_tales.R;
import a.childish_tales.recyclerview.slider.AdapterSlider;

public class AdapterMain extends RecyclerView.Adapter<AdapterMain.ViewHolder>{

  private List<ItemMain> itemIntroList;
  private LayoutInflater mInflater;
  private Context context;

  // data is passed into the constructor
  public AdapterMain(Context context, List<ItemMain> itemIntroList) {
    this.context = context;
    this.mInflater = LayoutInflater.from(context);
    this.itemIntroList = itemIntroList;
  }

  // inflates the row layout from xml when needed
  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = mInflater.inflate(R.layout.item_main_recycler, parent, false);
    return new ViewHolder(view);
  }

  // binds the data to the TextView in each row
  @Override
  public void onBindViewHolder(ViewHolder holder, final int position) {
    ItemMain item = itemIntroList.get(position);

    holder.textView.setText(item.getTitle());

    RecyclerView mRecyclerView;
    AdapterSlider mAdapter;
    SkidRightLayoutManager mSkidRightLayoutManager;

    mRecyclerView = holder.recyclerView;
    mAdapter = new AdapterSlider(context,item.getItemTwos());
    mRecyclerView.setAdapter(mAdapter);

    mSkidRightLayoutManager = new SkidRightLayoutManager(1.3f, 0.9f);
    mRecyclerView.setLayoutManager(mSkidRightLayoutManager);
  }

  // total number of rows
  @Override
  public int getItemCount() {
    return itemIntroList.size();
  }


  // stores and recycles views as they are scrolled off screen
  public class ViewHolder extends RecyclerView.ViewHolder{
      TextView textView;
      RecyclerView recyclerView;
    ViewHolder(View itemView) {
      super(itemView);
      textView = itemView.findViewById(R.id.text_view);
      recyclerView = itemView.findViewById(R.id.recycler_view);
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