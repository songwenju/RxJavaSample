package com.example.songwenju.rxjavasample.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.songwenju.rxjavasample.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * songwenju on 16-8-17 : 10 : 50.
 * 邮箱：songwenju@outlook.com
 */
public class ItemDetailFragment extends Fragment {

    @BindView(R.id.item_detail)
    TextView mItemDetail;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_detail, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onItemClick(Item item) {
        if (item != null) {
            switch (item.id) {
                case "1":
                    mItemDetail.setText(JavaBlock.SCHEDULER);
                    break;
                case "2":
                    mItemDetail.setText(JavaBlock.MERGE);
                    break;
                case "3":
                    mItemDetail.setText(JavaBlock.TIMER);
                    break;
                case "4":
                    mItemDetail.setText(JavaBlock.INTERVAL);
                    break;
                case "5":
                    mItemDetail.setText(JavaBlock.THROTTLEFIRST);
                    break;
                case "6":
                    mItemDetail.setText(JavaBlock.PERIODICALLY);
                    break;
                case "7":
                    mItemDetail.setText(JavaBlock.LIST);
                    break;
                case "8":
                    mItemDetail.setText(JavaBlock.UPDATE);
                    break;
                case "9":
                    mItemDetail.setText(JavaBlock.CACHE_CHECK);
                    break;
                case "10":
                    mItemDetail.setText(JavaBlock.COMBINE_LATEST);
                    break;
                case "11":
                    mItemDetail.setText(JavaBlock.TEXT_SEARCH);
                    break;
            }
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
