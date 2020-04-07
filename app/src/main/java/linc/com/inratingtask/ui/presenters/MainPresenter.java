package linc.com.inratingtask.ui.presenters;

import linc.com.inratingtask.ui.views.MainView;

public interface MainPresenter {

    void bind(final MainView view);
    void loadUsers(final String token);
    void unbind();
}
