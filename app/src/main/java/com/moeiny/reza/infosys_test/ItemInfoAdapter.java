package com.moeiny.reza.infosys_test;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ItemInfoAdapter extends BaseAdapter {

        final ArrayList<ItemInfo> listInfoList;

    ItemInfoAdapter(ArrayList<ItemInfo> listInfoList) {
            this.listInfoList = listInfoList;
        }

       //Return the Size of Array List<ItemInfo>
        @Override
        public int getCount() {
            return listInfoList.size();
        }

        //Return the selected ItemInfo Item in ListView
        @Override
        public Object getItem(int position) {
            return listInfoList.get(position);
        }

    //Return the Id of selected Item in ListView
        @Override
        public long getItemId(int position) {
            return listInfoList.get(position).id;
        }

    //Set the Value Of ItemInfo to a View Item and return view
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View viewProduct;
            if (convertView == null) {
                viewProduct = View.inflate(parent.getContext(), R.layout.item_row, null);
            } else viewProduct = convertView;

            ItemInfo itemInfo = (ItemInfo) getItem(position);
            ((TextView) viewProduct.findViewById(R.id.txt_title)).setText( itemInfo.title);
            ((TextView) viewProduct.findViewById(R.id.txt_desc)).setText(itemInfo.description);
            Picasso.with(G.context).load(itemInfo.imageUrl).into((ImageView) viewProduct.findViewById(R.id.img_Icon));


            return viewProduct;
        }

}
