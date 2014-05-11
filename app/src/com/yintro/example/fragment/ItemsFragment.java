//package com.yintro.example.fragment;
//
//import android.content.Context;
//import android.util.Log;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AdapterView;
//import android.widget.BaseAdapter;
//import android.widget.Button;
//import android.widget.LinearLayout;
//import android.widget.ListView;
//import android.widget.TextView;
//
//import com.google.gson.Gson;
//import com.loopj.android.http.AsyncHttpClient;
//import com.loopj.android.http.JsonHttpResponseHandler;
//import com.yintro.lazyandroid.app.fragment.BaseFragment;
//import com.yintro2hand.app.R;
//import com.yintro2hand.app.api.Route;
//import com.yintro2hand.app.api.model.Item;
//import com.yintro2hand.app.widget.ItemView;
//
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// *
// * Example connet to yintro2hand.api
// * Created by hoyin on 9/5/14.
// * Yintro.com
// */
//public class ItemsFragment extends BaseFragment implements AdapterView.OnItemClickListener, View.OnClickListener {
//
//
//    private ItemAdapter itemAdapter;
//
//    private ListView lvItem;
//    private TextView tvEmpty;
//    private LinearLayout vgHeaderControl;
//    private Button btnMenu;
//    private Button btnAdd;
//    private Button btnRefresh;
//
//
//    @Override
//    protected void assignViews() {
//        lvItem = (ListView) findViewById(R.id.lvItem);
//        tvEmpty = (TextView) findViewById(R.id.tvEmpty);
//        vgHeaderControl = (LinearLayout) findViewById(R.id.vgHeaderControl);
//        btnMenu = (Button) findViewById(R.id.btnMenu);
//        btnAdd = (Button) findViewById(R.id.btnAdd);
//        btnRefresh = (Button) findViewById(R.id.btnRefresh);
//    }
//
//    @Override
//    protected void setListeners() {
//        lvItem.setOnItemClickListener(this);
//        btnMenu.setOnClickListener(this);
//        btnAdd.setOnClickListener(this);
//        btnRefresh.setOnClickListener(this);
//    }
//
//    @Override
//    protected void init() {
//        itemAdapter = new ItemAdapter(getActivity());
//        lvItem.setEmptyView(tvEmpty);
//        lvItem.setAdapter(itemAdapter);
//        getData();
//    }
//
//    @Override
//    protected void getData() {
//
//        new AsyncHttpClient().get(Route.ITEMS, new JsonHttpResponseHandler() {
//            @Override
//            public void onSuccess(JSONObject response) {
//                try {
//                    Gson gson = new Gson();
//                    JSONArray data = response.getJSONArray("data");
//                    for (int i = 0; i < data.length(); i++) {
//                        try {
//
//                            Log.d("A", data.toString());
//                            Item item = gson.fromJson(data.toString(), Item.class);
//                            Log.d("A", item.toString());
////                            item.save();
//                        }catch (Exception ex1){
//                            ex1.printStackTrace();
//                            ex1.printStackTrace();
//                        }
//                    }
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
////                List<Item> items = new Select()
////                        .from(Item.class)
////                        .execute();
////                itemAdapter.addItems(items);
//
//
//            }
//        });
//
////        lvItem.setAdapter(new SimpleCursorAdapter(getActivity(),
////                android.R.layout.simple_expandable_list_item_1,
////                null,
////                new String[] { "MyProperty" },
////                new int[] { android.R.id.text1 },
////                0));
////
////        getActivity().getSupportLoaderManager().initLoader(0, null, new LoaderCallbacks<Cursor>() {
////            @Override
////            public Loader<Cursor> onCreateLoader(int arg0, Bundle cursor) {
////                return new CursorLoader(getActivity(),
////                        ContentProvider.createUri(MyEntityClass.class, null),
////                        null, null, null, null
////                );
////            }
////
////            @Override
////            public void onLoadFinished(Loader<Cursor> arg0, Cursor cursor) {
////                ((SimpleCursorAdapter)mySpinner.getAdapter()).swapCursor(cursor);
////            }
////
////            @Override
////            public void onLoaderReset(Loader<Cursor> arg0) {
////                ((SimpleCursorAdapter)mySpinner.getAdapter()).swapCursor(null);
////            }
////        });
//
//    }
//
//    @Override
//    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//
//    }
//
//    @Override
//    public void onClick(View view) {
//
//    }
//
//
//    private class ItemAdapter extends BaseAdapter {
//        List<Item> mItems;
//
//        Context mContext;
//
//        private ItemAdapter(Context context) {
//            mContext = context;
//            mItems = new ArrayList<Item>();
//        }
//
//        public void addItems(List<Item> items) {
//            this.mItems.addAll(items);
//        }
//
//        @Override
//        public int getCount() {
//            return mItems.size();
//        }
//
//        @Override
//        public Item getItem(int position) {
//            return mItems.get(position);
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return position;
//        }
//
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            ItemView item = (ItemView) convertView;
//            if (item == null) {
//                item = new ItemView(getActivity());
//            }
//            item.parse(mItems.get(position));
//            return item;
//        }
//    }
//}
//
