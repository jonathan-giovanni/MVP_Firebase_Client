package hv.dev4u.org.mvp_firebase_client.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import hv.dev4u.org.mvp_firebase_client.R;
import hv.dev4u.org.mvp_firebase_client.model.Category;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    ArrayList<Category> list;
    Context context;

    public CategoryAdapter(ArrayList<Category> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_category, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Category c = list.get(i);

        viewHolder.lblTitle.setText(c.getTitle());
        viewHolder.lblDescription.setText(c.getDescription());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView lblTitle;
        private TextView lblDescription;

        public ViewHolder(View itemView) {
            super(itemView);
            lblTitle = itemView.findViewById(R.id.lblCategoryTitleItem);
            lblDescription = itemView.findViewById(R.id.lblCategoryDescItem);
        }
    }
}
