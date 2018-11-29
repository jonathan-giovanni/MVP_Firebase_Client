package hv.dev4u.org.mvp_firebase_client.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import hv.dev4u.org.mvp_firebase_client.contract.CategoryContract;
import hv.dev4u.org.mvp_firebase_client.R;
import hv.dev4u.org.mvp_firebase_client.adapter.CategoryAdapter;
import hv.dev4u.org.mvp_firebase_client.model.Category;
import hv.dev4u.org.mvp_firebase_client.presenter.CategoryPresenter;

public class CategoryListActivity extends AppCompatActivity implements CategoryContract.View {

    ArrayList<Category> list = new ArrayList<>();
    CategoryAdapter categoryAdapter;

    CategoryPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new CategoryPresenter(this);

        RecyclerView recycler = findViewById(R.id.recyclerCategory);
        recycler.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(mLayoutManager);

        categoryAdapter = new CategoryAdapter(list,this);

        recycler.setAdapter(categoryAdapter);
    }

    @Override
    public void addItem(Category category) {
        list.add(category);
        categoryAdapter.notifyItemInserted(list.size()-1);
    }

    @Override
    public void updateItem(int position, Category category) {
        list.set(position,category);
        categoryAdapter.notifyItemChanged(position);
    }


    @Override
    public void deleteItem(int position) {
        list.remove(position);
        categoryAdapter.notifyItemRemoved(position);
    }

}
