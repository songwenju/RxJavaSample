package com.example.songwenju.rxjavasample.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * songwenju on 16-8-16 : 18 : 04.
 * 邮箱：songwenju@outlook.com
 */
public class ItemListFragment extends ListFragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EventBus.getDefault().post(new ItemListEvent(Item.ITEMS));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        EventBus.getDefault().post(getListView().getItemAtPosition(position));
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void setListAdapter(ItemListEvent event){
        setListAdapter(new ArrayAdapter<>(
                getActivity(),android.R.layout.simple_list_item_activated_1,
                android.R.id.text1,event.getItems()
        ));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
