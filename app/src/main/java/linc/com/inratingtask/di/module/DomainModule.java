package linc.com.inratingtask.di.module;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;
import linc.com.inratingtask.data.MainRepository;
import linc.com.inratingtask.domain.MainInteractor;
import linc.com.inratingtask.domain.MainInteractorImpl;

@Module
public class DomainModule {

    @Provides
    public MainInteractor provideInteractor(MainRepository repository) {
        return new MainInteractorImpl(repository);
    }

}
