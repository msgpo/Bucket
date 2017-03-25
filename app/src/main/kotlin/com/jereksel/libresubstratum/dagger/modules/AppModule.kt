package com.jereksel.libresubstratum.dagger.modules

import android.app.Application
import com.jereksel.libresubstratum.activities.detailed.DetailedPresenter
import com.jereksel.libresubstratum.activities.main.MainPresenter
import com.jereksel.libresubstratum.activities.main.Presenter
import com.jereksel.libresubstratum.domain.AppPackageManager
import com.jereksel.libresubstratum.domain.IPackageManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
open class AppModule(private val application: Application) {

    @Provides
    @Singleton
    fun providesApplication() = application

    @Provides
    @Singleton
    open fun providesPackageManager(application: Application): IPackageManager {
        return AppPackageManager(application)
    }

    @Provides
    @Singleton
    open fun providesMainPresenter(packageManager: IPackageManager): Presenter {
        return MainPresenter(packageManager)
    }

    @Provides
    @Singleton
    open fun providesDetailedPresenter(packageManager: IPackageManager) : com.jereksel.libresubstratum.activities.detailed.Presenter {
        return DetailedPresenter(packageManager)
    }
}