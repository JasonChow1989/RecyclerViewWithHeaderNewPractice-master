package me.drakeet.recyclerviewwithheadernewpractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ImageAdapter mAdapter;
    private View mHeader;
    private Toast mToast;


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHeader = findViewById(R.id.header);
        // You get the header views, and you can bind data with the views now
        mHeader.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                showToast("This is Header");
            }
        });
        mAdapter = new ImageAdapter(new int[] { R.drawable.demo_list });
        setupRecyclerView();
    }


    private void showToast(String s) {
        if (mToast != null) {
            mToast.cancel();
        }
        mToast = Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT);
        mToast.show();
    }


    private void setupRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);
    }


    protected class ImageAdapter
            extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

        int[] resIds;


        public ImageAdapter(int[] resIds) {
            this.resIds = resIds;
        }


        @Override
        public ImageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                                   .inflate(R.layout.item, parent, false);
            return new ImageAdapter.ViewHolder(v);
        }


        @Override
        public void onBindViewHolder(ImageAdapter.ViewHolder holder, int position) {
            // pass
        }


        @Override public int getItemCount() {
            return resIds.length;
        }


        public class ViewHolder extends RecyclerView.ViewHolder {

            public ViewHolder(View itemView) {
                super(itemView);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override public void onClick(View v) {
                        showToast("This is RecyclerView Item");
                    }
                });
            }
        }
    }
}
