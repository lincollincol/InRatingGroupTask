package linc.com.inratingtask.di;

import javax.inject.Singleton;

import dagger.Component;
import io.reactivex.disposables.CompositeDisposable;
import linc.com.inratingtask.di.module.AppModule;
import linc.com.inratingtask.di.module.DataModule;
import linc.com.inratingtask.di.module.DomainModule;
import linc.com.inratingtask.di.module.PresentationModule;
import linc.com.inratingtask.ui.MainActivity;

@Singleton
@Component(modules = {AppModule.class, PresentationModule.class, DataModule.class, DomainModule.class})
public interface AppComponent {
//    CompositeDisposable compositeDisposable();
    void inject(MainActivity activity);
}
