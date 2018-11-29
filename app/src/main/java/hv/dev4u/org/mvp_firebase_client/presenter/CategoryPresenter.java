package hv.dev4u.org.mvp_firebase_client.presenter;

import hv.dev4u.org.mvp_firebase_client.contract.CategoryContract;
import hv.dev4u.org.mvp_firebase_client.model.Category;

public class CategoryPresenter implements CategoryContract.Presenter {

    CategoryContract.View view;
    CategoryInteractor interactor;

    public CategoryPresenter(final CategoryContract.View view){
        this.view   = view;
        interactor  = new CategoryInteractor(this);
    }

    @Override
    public void addItem(Category category) {
        view.addItem(category);
    }

    @Override
    public void updateItem(int position, Category category) {
        view.updateItem(position,category);
    }

    @Override
    public void deleteItem(int position) {
        view.deleteItem(position);
    }
}
