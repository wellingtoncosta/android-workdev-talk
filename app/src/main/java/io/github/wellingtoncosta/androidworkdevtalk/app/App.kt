package io.github.wellingtoncosta.androidworkdevtalk.app

import android.app.Application
import io.github.wellingtoncosta.androidworkdevtalk.domain.ContactRepository
import io.github.wellingtoncosta.androidworkdevtalk.resource.ContactDatabaseRepository
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.module
import java.util.Collections.singletonList

class App : Application() {

    private val appModule = module {
        single { ContactDatabaseRepository() as ContactRepository }
    }

    override fun onCreate() {
        super.onCreate()

        startKoin(this, singletonList(appModule))
    }

}