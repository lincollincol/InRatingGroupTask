package linc.com.inratingtask.di.module;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;
import linc.com.inratingtask.domain.MainInteractor;
import linc.com.inratingtask.ui.presenters.MainPresenter;
import linc.com.inratingtask.ui.presenters.MainPresenterImpl;

@Module
public class PresentationModule {

    @Provides
    public MainPresenter providePresenter(MainInteractor interactor, CompositeDisposable compositeDisposable) {
        return new MainPresenterImpl(interactor, compositeDisposable);
    }


}

