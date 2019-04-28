package io.github.wellingtoncosta.androidworkdevtalk.app

import android.app.Application
import io.github.wellingtoncosta.androidworkdevtalk.app.contactregistration.ContactRegistrationViewModel
import io.github.wellingtoncosta.androidworkdevtalk.app.listcontacts.ListContactsViewModel
import io.github.wellingtoncosta.androidworkdevtalk.domain.ContactRepository
import io.github.wellingtoncosta.androidworkdevtalk.resource.ContactDatabaseRepository
import org.koin.android.ext.android.startKoin
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import java.util.Collections.singletonList

class App : Application() {

    private val appModule = module {
        single { ContactDatabaseRepository() as ContactRepository }

        viewModel { ListContactsViewModel(get()) }
        viewModel { ContactRegistrationViewModel(get()) }
    }

    override fun onCreate() {
        super.onCreate()

        startKoin(this, singletonList(appModule))
    }

}