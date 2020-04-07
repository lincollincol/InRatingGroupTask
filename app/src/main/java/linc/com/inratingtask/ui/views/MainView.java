package linc.com.inratingtask.ui.views;

import java.util.List;

import linc.com.inratingtask.domain.models.StatisticEntity;

public interface MainView {

    void showStatistics(List<StatisticEntity> statistics);
    void clearStatistics();

}
