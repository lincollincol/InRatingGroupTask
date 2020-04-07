package linc.com.inratingtask.ui.presenters;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import linc.com.inratingtask.domain.MainInteractor;
import linc.com.inratingtask.ui.views.MainView;

public class MainPresenterImpl implements MainPresenter{

    private MainView view;
    private MainInteractor interactor;
    private CompositeDisposable disposableBag;

    public MainPresenterImpl(MainInteractor interactor, CompositeDisposable disposableBag) {
        this.interactor = interactor;
        this.disposableBag = disposableBag;
    }

    @Override
    public void bind(final MainView view) {
        this.view = view;
    }

    @Override
    public void loadUsers(final String token) {
        view.clearStatistics();
        disposableBag.add(
            interactor.execute(token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(view::showStatistics, e->e.printStackTrace())
        );
    }

    @Override
    public void unbind() {
        if (!disposableBag.isDisposed()) {
            disposableBag.dispose();
        }
        interactor = null;
        disposableBag = null;
    }

}
