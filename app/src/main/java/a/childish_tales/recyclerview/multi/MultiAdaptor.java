package a.childish_tales.recyclerview.multi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.dingmouren.layoutmanagergroup.skidright.SkidRightLayoutManager;

import java.util.ArrayList;

import a.childish_tales.R;
import a.childish_tales.activtiy.InfoStoryActivity;
import a.childish_tales.activtiy.MainActivity;
import a.childish_tales.activtiy.WebViewActivity;
import a.childish_tales.recyclerview.AdapterSliderHorezontal;
import a.childish_tales.recyclerview.AdapterSliderLakcheri;
import a.childish_tales.recyclerview.AdapterSliderVertical;

public class MultiAdaptor extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<MultiItem> itemMains;
    private Context mContext;
    private int total_types;

    public static class holder_TextBox extends RecyclerView.ViewHolder {
        View view;
        TextView textView;
        holder_TextBox(View itemView) {
            super(itemView);
            view = itemView;
            this.textView = itemView.findViewById(R.id.text_view);
        }
    }
    public static class holder_TwoIcon extends RecyclerView.ViewHolder {
        View view_1,view_2;
        ImageView imageView_1,imageView_2;
        TextView textView_1,textView_2;
        holder_TwoIcon(View itemView) {
            super(itemView);
            view_1 = itemView.findViewById(R.id.view_1);
            imageView_1 = itemView.findViewById(R.id.image_view_1);
            textView_1 = itemView.findViewById(R.id.text_view_1);
            view_2 = itemView.findViewById(R.id.view_2);
            imageView_2 = itemView.findViewById(R.id.image_view_2);
            textView_2 = itemView.findViewById(R.id.text_view_2);
        }
    }
    public static class holder_SliderLackcheri extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        holder_SliderLackcheri(View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.recycler_view);
        }
    }
    public static class holder_Image extends RecyclerView.ViewHolder {
        View view;
        ImageView imageView;
        TextView textView;
        holder_Image(View itemView) {
            super(itemView);
            view = itemView;
            imageView = itemView.findViewById(R.id.image_view);
            textView = itemView.findViewById(R.id.text_view);
        }
    }
    public static class holder_SliderHorizontal extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        holder_SliderHorizontal(View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.recycler_view);
        }
    }
    public static class holder_SliderVertical extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        holder_SliderVertical(View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.recycler_view);
        }
    }
    public static class holder_Title extends RecyclerView.ViewHolder {
        View view;
        TextView textView;
        ImageView icon;
        holder_Title(View itemView) {
            super(itemView);
            view = itemView;
            textView = itemView.findViewById(R.id.text_view);
            icon = itemView.findViewById(R.id.icon);
        }
    }

    public MultiAdaptor(ArrayList<MultiItem> data, Context context ) {
        this.itemMains = data;
        this.mContext = context;
        total_types = itemMains.size();

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case MultiItem.TEXT_BOX :
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_text_box, parent, false);
                return new holder_TextBox(view);
            case MultiItem.IMAGE :
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);
                return new holder_Image(view);
            case MultiItem.TITLE :
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_title, parent, false);
                return new holder_Title(view);
            case MultiItem.SLIDER_LAKCHERI :
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recylcerview, parent, false);
                return new holder_SliderLackcheri(view);
            case MultiItem.SLIDER_HORIZONTAL :
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recylcerview, parent, false);
                return new holder_SliderHorizontal(view);
            case MultiItem.SLIDER_VERTICAL :
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recylcerview, parent, false);
                return new holder_SliderVertical(view);
        }
        return null;
    }


    @Override
    public int getItemViewType(int position) {

        switch (itemMains.get(position).type) {
            case 92:
                return MultiItem.TEXT_BOX;
            case 110612222:
                return MultiItem.TWO_ICON;
            case 135213:
                return MultiItem.SLIDER_LAKCHERI;
            case 118:
                return MultiItem.IMAGE;
            case 128:
                return MultiItem.SLIDER_HORIZONTAL;
            case 68:
                return MultiItem.SLIDER_VERTICAL;
            case 303:
                return MultiItem.TITLE;
            default:
                return -1;
        }


    }

    Intent intent = null;
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int listPosition) {
        final MultiItem object = itemMains.get(listPosition);
        if (object != null) {
            switch (object.type) {
                case MultiItem.TEXT_BOX:
                    View view = ((holder_TextBox)holder).view;
                    TextView text = ((holder_TextBox)holder).textView;
                    text.setText(object.getText());

                    setIntent(object);
                    view.setOnClickListener(this::on_click);

                    break;

                case MultiItem.IMAGE:
                    View view1 = ((holder_Image)holder).view;
                    ImageView imageView = ((holder_Image)holder).imageView;
                    TextView textView = ((holder_Image)holder).textView;

                    Glide.with(mContext).load(object.getImage()).into(imageView);
                    textView.setText(object.getTitle());
                    break;

                case MultiItem.TITLE:
                    TextView title1 = ((holder_Title)holder).textView;
                    ImageView icon = ((holder_Title)holder).icon;
                    title1.setText(object.getTitle());
                    if (object.isBoolean()){
                        icon.setVisibility(View.VISIBLE);
                    }else {
                        icon.setVisibility(View.INVISIBLE);
                    }
                    break;

                case MultiItem.SLIDER_LAKCHERI:
                    RecyclerView mRecyclerView = ((holder_SliderLackcheri)holder).recyclerView;
                    AdapterSliderLakcheri mAdapter = new AdapterSliderLakcheri(mContext,object.getArrayList());
                    mRecyclerView.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layou= new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false);
                    SkidRightLayoutManager mSkidRightLayoutManager = new SkidRightLayoutManager(1.3f, 0.9f);
                    mRecyclerView.setLayoutManager(layou);
                    break;

                case MultiItem.SLIDER_HORIZONTAL:
                    RecyclerView recyclerView_H = ((holder_SliderHorizontal)holder).recyclerView;
                    AdapterSliderHorezontal adapter_H = new AdapterSliderHorezontal(mContext,object.getArrayList());
                    recyclerView_H.setAdapter(adapter_H);
                    RecyclerView.LayoutManager layout_H= new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false);
                    recyclerView_H.setLayoutManager(layout_H);
                    break;

                case MultiItem.SLIDER_VERTICAL:
                    RecyclerView recyclerView_V = ((holder_SliderVertical)holder).recyclerView;
                    AdapterSliderVertical adapter_V = new AdapterSliderVertical(mContext,object.getArrayList());
                    recyclerView_V.setAdapter(adapter_V);
                    RecyclerView.LayoutManager layout_V= new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false);
                    recyclerView_V.setLayoutManager(layout_V);
                    break;

            }
        }
    }

    @Override
    public int getItemCount() {
        return itemMains.size();
    }


    void setIntent(MultiItem object){
        switch (object.getOn_click()){
            case 1:
                intent = new Intent(mContext, InfoStoryActivity.class);
                intent.putExtra("title",object.getStory_title());
                intent.putExtra("desc",object.getStory_desc());
                intent.putExtra("image",object.getStory_image());
                intent.putExtra("sound_name",object.getStory_soundName());
                intent.putExtra("sound",object.getStory_sound());
                break;
            case 2:
//                intent = new Intent(mContext, WebViewActivity.class);
//                intent.putExtra("url",object.getUrl());
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(object.getUrl()));
                break;
            case 3:
                intent = new Intent(mContext,MainActivity.class);
                intent.putExtra("url",object.getUrl());
                break;
            default:
                intent = null;
                break;
        }
    }
    void on_click(View view){
        view.setOnClickListener(onclick -> {
            if (intent !=null){
                (mContext).startActivity(intent);
            }
        });
    }

}