package com.example.appnhac.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;


import com.example.appnhac.Model.Quangcao;
import com.example.appnhac.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BannerAdapter extends PagerAdapter {



    Context context;

    ArrayList<Quangcao> arrayListquangcao;

    public BannerAdapter(Context context, ArrayList<Quangcao> arrayListquangcao) {
        this.context = context;
        this.arrayListquangcao = arrayListquangcao;
    }

    @Override
    public int getCount() {
        return arrayListquangcao.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_banner,null);
        ImageView imgbackgroundbanner = view.findViewById(R.id.imageviewbackgroundbanner);
        ImageView imgsongbanner = view.findViewById(R.id.imageviewbanner);
        TextView txtsongtitlebanner = view.findViewById(R.id.textviewtitlebannerbaihat);
        TextView txtnoidung = view.findViewById(R.id.textviewnoidung);

        Picasso.with(context).load(arrayListquangcao.get(position).getHinhAnh()).into(imgbackgroundbanner);
        Picasso.with(context).load(arrayListquangcao.get(position).getHinhBaiHat()).into(imgsongbanner);
        txtsongtitlebanner.setText(arrayListquangcao.get(position).getTenBaiHat());
        txtnoidung.setText(arrayListquangcao.get(position).getNoiDung());

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);

    }
}
