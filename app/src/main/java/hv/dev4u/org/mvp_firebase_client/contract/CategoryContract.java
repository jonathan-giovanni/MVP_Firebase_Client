package hv.dev4u.org.mvp_firebase_client.contract;


import hv.dev4u.org.mvp_firebase_client.model.Category;

public interface CategoryContract {
    interface View {
        void addItem(Category category);
        void updateItem(int position,Category category);
        void deleteItem(int position);
    }

    interface Presenter{

        void addItem(Category category);
        void updateItem(int position,Category category);
        void deleteItem(int position);
    }
}
