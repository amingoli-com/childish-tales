package a.childish_tales.recyclerview.multi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dingmouren.layoutmanagergroup.skidright.SkidRightLayoutManager;

import java.util.ArrayList;

import a.childish_tales.R;
import a.childish_tales.recyclerview.slider_lakcheri.AdapterSlider;

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
            textView_1 = itemView.findViewById(R.id.image_view_2);
            view_2 = itemView.findViewById(R.id.view_2);
            imageView_2 = itemView.findViewById(R.id.text_view_1);
            textView_2 = itemView.findViewById(R.id.text_view_2);
        }
    }
    public static class holder_SliderLackcheri extends RecyclerView.ViewHolder {
        /*View view,box_detail;
        ImageView imageView;
        TextView title,desc,writer_narrator,time;*/
        RecyclerView recyclerView;
        holder_SliderLackcheri(View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.recycler_view);
            /*view = itemView;
            imageView = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
            time = itemView.findViewById(R.id.time);
            desc = itemView.findViewById(R.id.desc);
            writer_narrator = itemView.findViewById(R.id.writer_narrator);
            box_detail = itemView.findViewById(R.id.box_detail);*/
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
        View view;
        ImageView imageView;
        TextView textView;
        holder_SliderHorizontal(View itemView) {
            super(itemView);
            view = itemView;
            imageView = itemView.findViewById(R.id.image_view);
            textView = itemView.findViewById(R.id.text_view);
        }
    }
    public static class holder_SliderVertical extends RecyclerView.ViewHolder {
        View view;
        ImageView imageView;
        TextView title,desc;
        holder_SliderVertical(View itemView) {
            super(itemView);
            view = itemView;
            imageView = itemView.findViewById(R.id.image_view);
            title = itemView.findViewById(R.id.title);
            desc = itemView.findViewById(R.id.desc);

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
            case MultiItem.TWO_ICON :
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_two_icon, parent, false);
                return new holder_TwoIcon(view);
            case MultiItem.SLIDER_LAKCHERI :
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_slider_lackcheri_recylcerview, parent, false);
                return new holder_SliderLackcheri(view);
            case MultiItem.IMAGE :
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);
                return new holder_Image(view);
            case MultiItem.SLIDER_HORIZONTAL :
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_slider_horizontal, parent, false);
                return new holder_SliderHorizontal(view);
            case MultiItem.SLIDER_VERTICAL :
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_slider_vertical, parent, false);
                return new holder_SliderVertical(view);
            case MultiItem.TITLE :
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_title, parent, false);
                return new holder_Title(view);
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

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int listPosition) {
        final MultiItem object = itemMains.get(listPosition);
        if (object != null) {
            switch (object.type) {
                case MultiItem.TEXT_BOX:

                    break;
                case MultiItem.TWO_ICON:

                    break;
                case MultiItem.SLIDER_LAKCHERI:
                    RecyclerView mRecyclerView;
                    AdapterSlider mAdapter;
                    SkidRightLayoutManager mSkidRightLayoutManager;

                    mRecyclerView = ((holder_SliderLackcheri)holder).recyclerView;
                    mAdapter = new AdapterSlider(mContext,object.getItemSliderLakcheri());
                    mRecyclerView.setAdapter(mAdapter);

                    mSkidRightLayoutManager = new SkidRightLayoutManager(1.3f, 0.9f);
//                  RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
                    mRecyclerView.setLayoutManager(mSkidRightLayoutManager);
                    break;
                case MultiItem.IMAGE:

                    break;
                case MultiItem.SLIDER_HORIZONTAL:

                    break;
                case MultiItem.SLIDER_VERTICAL:

                    break;
                case MultiItem.TITLE:
                    TextView title = ((holder_Title)holder).textView;
                    ImageView icon = ((holder_Title)holder).icon;
                    title.setText(object.getText_TITLE());
                    if (object.isShow_flash_TITLE()){
                        icon.setVisibility(View.VISIBLE);
                    }else {
                        icon.setVisibility(View.INVISIBLE);
                    }
                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return itemMains.size();
    }

}