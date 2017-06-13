package com.example.administrator.live.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.live.Activity.LogActivity;
import com.example.administrator.live.Activity.LoginActivity;
import com.example.administrator.live.Bean.MessageEvent;
import com.example.administrator.live.R;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

/**
 * Created by Administrator on 2017/5/15.
 */

public class MienFragment extends Fragment {

    public boolean flag;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mien, null);
        EventBus.getDefault().register(this);
        TextView mine_name= (TextView) view.findViewById(R.id.mine_name);
        mine_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), LogActivity.class));
            }
        });
        ImageView mine_img= (ImageView) view.findViewById(R.id.mine_right);
        mine_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), LoginActivity.class));
            }
        });
        return view;
    }
    @Subscribe(threadMode = ThreadMode.MainThread)
    public void setEventBus(MessageEvent eventBus){
        flag = eventBus.getFlag();
        Log.d("sxd", flag+"");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }
}
