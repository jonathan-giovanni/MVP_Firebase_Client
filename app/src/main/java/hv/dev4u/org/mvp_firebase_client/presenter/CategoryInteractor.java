package hv.dev4u.org.mvp_firebase_client.presenter;

import android.content.Context;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import hv.dev4u.org.mvp_firebase_client.model.Category;
import hv.dev4u.org.mvp_firebase_client.model.Item;

public class CategoryInteractor {


    ArrayList<Category> list = new ArrayList<>();

    CollectionReference categoryCollection = FirebaseFirestore.getInstance().collection("category");

    CategoryPresenter presenter;

    CategoryInteractor(CategoryPresenter presenter) {
        this.presenter = presenter;
        categoryListener();
    }

    private void categoryListener(){
        categoryCollection.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                updateValues(queryDocumentSnapshots.getDocumentChanges());
            }
        });


    }


    protected void updateValues(List<DocumentChange> changeList) {

        int position;
        for(DocumentChange document_changed: changeList){

            DocumentSnapshot document = document_changed.getDocument();
            position = itemPosition(document.getId());

            if(document_changed.getType()==DocumentChange.Type.REMOVED){

                list.remove(position);

                presenter.deleteItem(position);
            }else {

                Category category = getCategory(document);

                if (position >= 0) {

                    list.set(position, category);

                    presenter.updateItem(position,category);
                } else {

                    list.add(category);

                    presenter.addItem(category);
                }
            }
        }
    }


    private int itemPosition(String id) {
        for(Item item : list) {
            if(item.getId().equals(id)) {
                return list.indexOf(item);
            }
        }
        return -1;
    }


    public Category getCategory(DocumentSnapshot document) {

        Category category = new Category();

        category.setId(document.getId());
        category.setTitle(document.getString("title"));
        category.setDescription(document.getString("description"));

        return category;
    }

}
