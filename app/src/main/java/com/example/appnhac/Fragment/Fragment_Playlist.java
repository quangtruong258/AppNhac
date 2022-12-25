package com.example.appnhac.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.appnhac.Model.Playlist;
import com.example.appnhac.R;
import com.example.appnhac.Service.APIService;
import com.example.appnhac.Service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Playlist extends Fragment {
    View view;

    ListView listView;
    TextView tenplaylist,xemthemplaylist;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_playlist,container,false);
        listView = view.findViewById(R.id.listviewplaylist);
        tenplaylist = view.findViewById(R.id.textviewtitleplaylist);
        xemthemplaylist = view.findViewById(R.id.textviewmoreplaylist);

        GetData();
        return view;
    }

    private void GetData() {
        DataService dataService = APIService.getService();
        Call<List<Playlist>> callback = dataService.GetPlaylistEveryDay();
        callback.enqueue(new Callback<List<Playlist>>() {
            @Override
            public void onResponse(Call<List<Playlist>> call, Response<List<Playlist>> response) {
                ArrayList<Playlist> dsplaylist = (ArrayList<Playlist>) response.body();
            }

            @Override
            public void onFailure(Call<List<Playlist>> call, Throwable t) {

            }
        });

    }
}
